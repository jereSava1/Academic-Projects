			mov EAX,%001
			mov EDX, 1
			mov ECX, 2
			sys 1 ;Recibo los 2 valores
			mov BX, [1] ;Dividendo
			mov CX, [2] ;Divisor
			xor [3], CX 
			xor [4], 1
			cmp CX, 0 ;Division por 0
			jz fin
			cmp BX, CX
			jn op1; (2:7)
sig:	mov [3], CX ;Coloco el divisor el [3]
			mul [3], [4]
			cmp BX, [3] ; Cuando el rtado de la mul > Dividendo
			jn op3; (7:2) ->Resto positivo
			jz op4; (8:4) ->Resto cero
			add [4], 1
			jmp sig
sg:   ;Cambiar signo de AX segun divisor y dividendo, los restos se mantienen
			cmp BX,0
			jn sg1; Si es negativo
			jp sg2; Si es positivo
imp:  mov [5], AX
			mov [6], DX
			mov EAX,%001
			mov EDX, 5
			mov ECX, 2
			sys 2
			stop

sg1: cmp CX,0
		 jp cambiaSg
		 jmp imp

sg2: cmp CX,0
		 jn cambiaSg
		 jmp imp

cambiaSg: mul AX, -1
			    jmp imp
	
;Division donde Divisor > Dividendo 2 : 7
op1:  mov DX, BX; El resto sera el dividendo
			mov AX, 0 ;Resultado de la division
			jmp sg

;Division donde Dividendo < Divisor, con resto  7 : 2
op3:  sub [3], BX ;Calculo el resto
			mov DX, [3]
			mov AX, [4]
			sub AX, 1
			jmp sg

;Division donde Dividendo < Divisor, sin resto 8 : 2
op4:  sub [3], BX ;Calculo el resto
			mov DX, [3]
			mov AX, [4]
			jmp sg
			
;Division por cero
fin:  stop