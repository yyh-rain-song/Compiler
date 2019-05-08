





default rel

global __hasValue
global __getValue
global __setValue
global __print
global __println
global __getString
global __getInt
global __toString
global __string_length
global __string_substring
global __string_parseInt
global __string_ord
global __stringConcate
global __stringCompare
global __value
global __has
global __real_addr
global main

extern strcmp
extern __sprintf_chk
extern memcpy
extern malloc
extern __isoc99_scanf
extern puts
extern __printf_chk


SECTION .text   6

__hasValue:
        mov     rax, rdi
        mov     rdx, qword 1323E34A2B10BF67H
        imul    rdx
        mov     rax, rdi
        sar     rax, 63
        sar     rdx, 3
        sub     rdx, rax
        mov     eax, 107
        imul    rdx, rax
        mov     rax, rdi
        sub     rax, rdx
        mov     rdx, rax
        xor     eax, eax

        cmp     qword [abs __real_addr+rdx*8], rdi
        jz      L_002
L_001:

        ret





ALIGN   8
L_002:  cmp     rsi, 209
        ja      L_001
        imul    rdx, rdx, 210
        add     rsi, rdx

        mov     rax, qword [abs __has+rsi*8]
        ret






ALIGN   8

__getValue:
        mov     rax, rdi
        mov     rdx, qword 1323E34A2B10BF67H
        imul    rdx
        mov     rax, rdi
        sar     rax, 63
        sar     rdx, 3
        sub     rdx, rax
        mov     eax, 107
        imul    rdx, rax
        sub     rdi, rdx
        imul    rdi, rdi, 210
        add     rsi, rdi

        mov     rax, qword [abs __value+rsi*8]
        ret






ALIGN   8

__setValue:
        cmp     rsi, 209
        mov     r9, rdx
        ja      L_008
        mov     r8, qword 1323E34A2B10BF67H
        mov     rax, rdi
        mov     r10d, 107
        imul    r8
        mov     rax, rdi
        sar     rax, 63
        mov     r8, rdx
        sar     r8, 3
        sub     r8, rax
        mov     rax, rdi
        imul    r8, r10
        sub     rax, r8
        mov     r8, rax

        mov     rax, qword [abs __real_addr+rax*8]
        cmp     rax, rdi
        jz      L_007
        test    rax, rax
        je      L_012
        imul    rax, r8, 1680
        mov     edx, 1680

        lea     rdi, [abs __has+rax]
        test    dil, 01H
        jne     L_013
L_003:  test    dil, 02H
        jne     L_014
L_004:  test    dil, 04H
        jne     L_015
L_005:  mov     ecx, edx
        xor     eax, eax
        shr     ecx, 3
        test    dl, 04H
        rep stosq
        jnz     L_011
        test    dl, 02H
        jnz     L_010
L_006:  and     edx, 01H
        jnz     L_009




ALIGN   8
L_007:  mov     rax, r9
        imul    r8, r8, 210
        add     rsi, r8

        mov     qword [abs __has+rsi*8], 1

        mov     qword [abs __value+rsi*8], r9
        ret





ALIGN   8
L_008:

        ret





ALIGN   8
L_009:  mov     byte [rdi], 0
        jmp     L_007





ALIGN   8
L_010:  xor     eax, eax
        add     rdi, 2
        mov     word [rdi-2H], ax
        and     edx, 01H
        jz      L_007
        jmp     L_009





ALIGN   8
L_011:  mov     dword [rdi], 0
        add     rdi, 4
        test    dl, 02H
        jz      L_006
        jmp     L_010





ALIGN   8
L_012:

        mov     qword [abs __real_addr+r8*8], rdi
        jmp     L_007





ALIGN   8
L_013:

        mov     byte [abs __has+rax], 0
        add     rdi, 1
        mov     dl, -113
        jmp     L_003





ALIGN   8
L_014:  xor     ecx, ecx
        add     rdi, 2
        sub     edx, 2
        mov     word [rdi-2H], cx
        jmp     L_004





ALIGN   8
L_015:  mov     dword [rdi], 0
        sub     edx, 4
        add     rdi, 4
        jmp     L_005







ALIGN   16

__print:
        lea     rdx, [rdi+8H]
        mov     esi, L_032
        mov     edi, 1
        xor     eax, eax
        jmp     __printf_chk







ALIGN   16

__println:
        add     rdi, 8
        jmp     puts






ALIGN   8

__getString:
        push    rbp
        mov     esi, __buffer.3442
        mov     edi, L_032
        xor     eax, eax
        push    rbx
        mov     ebx, __buffer.3442
        sub     rsp, 8
        call    __isoc99_scanf
L_016:  mov     edx, dword [rbx]
        add     rbx, 4
        lea     eax, [rdx-1010101H]
        not     edx
        and     eax, edx
        and     eax, 80808080H
        jz      L_016
        mov     edx, eax
        shr     edx, 16
        test    eax, 8080H
        cmove   eax, edx
        lea     rdx, [rbx+2H]
        cmove   rbx, rdx
        add     al, al
        sbb     rbx, 3
        sub     rbx, __buffer.3442
        lea     edi, [rbx+8H]
        movsxd  rdi, edi
        call    malloc
        mov     rbp, rax
        lea     rdx, [rbx+1H]
        movsxd  rax, ebx
        lea     rdi, [rbp+8H]
        mov     qword [rbp], rax
        mov     esi, __buffer.3442
        call    memcpy
        add     rsp, 8
        mov     rax, rbp
        pop     rbx
        pop     rbp
        ret







ALIGN   16

__getInt:
        sub     rsp, 24
        mov     edi, L_033
        xor     eax, eax
        lea     rsi, [rsp+8H]
        call    __isoc99_scanf
        mov     rax, qword [rsp+8H]
        add     rsp, 24
        ret


        nop

ALIGN   16
__toString:
        push    rbp
        mov     rbp, rdi
        mov     edi, 32
        push    rbx
        sub     rsp, 8
        call    malloc
        lea     rdi, [rax+8H]
        mov     rbx, rax
        mov     r8, rbp
        mov     ecx, L_033
        mov     edx, 24
        mov     esi, 1
        xor     eax, eax
        call    __sprintf_chk
        cdqe
        mov     qword [rbx], rax
        add     rsp, 8
        mov     rax, rbx
        pop     rbx
        pop     rbp
        ret







ALIGN   16

__string_length:
        mov     rax, qword [rdi]
        ret







ALIGN   16

__string_substring:
        push    r15
        push    r14
        push    r13
        movsxd  r13, esi
        push    r12
        mov     r12d, edx
        sub     r12d, r13d
        push    rbp
        mov     rbp, rdi
        lea     edi, [r12+0AH]
        push    rbx
        lea     ebx, [r12+1H]
        movsxd  rdi, edi
        sub     rsp, 8
        call    malloc
        movsxd  rdx, ebx
        test    ebx, ebx
        mov     qword [rax], rdx
        jle     L_018
        lea     edi, [r13+8H]
        add     r13, rbp
        lea     rcx, [rax+18H]
        lea     rdx, [r13+8H]
        lea     rsi, [r13+18H]
        cmp     rcx, rdx
        lea     rdx, [rax+8H]
        setbe   cl
        cmp     rsi, rdx
        setbe   dl
        or      cl, dl
        je      L_019
        cmp     ebx, 15
        jbe     L_019
        mov     esi, ebx
        xor     edx, edx
        xor     r8d, r8d
        shr     esi, 4
        mov     ecx, esi
        shl     ecx, 4
L_017:  movdqu  xmm0, oword [r13+rdx+8H]
        add     r8d, 1
        movdqu  oword [rax+rdx+8H], xmm0
        add     rdx, 16
        cmp     r8d, esi
        jc      L_017
        cmp     ebx, ecx
        je      L_018
        lea     edx, [rdi+rcx]
        lea     r13d, [rcx+8H]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r13d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+1H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r11d, [rcx+9H]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r11d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+2H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r10d, [rcx+0AH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r10d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+3H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r9d, [rcx+0BH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r9d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+4H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     r8d, [rcx+0CH]
        movsxd  rdx, edx
        movzx   esi, byte [rbp+rdx]
        movsxd  rdx, r8d
        mov     byte [rax+rdx], sil
        lea     edx, [rcx+5H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        lea     esi, [rcx+0DH]
        movsxd  rdx, edx
        movzx   r14d, byte [rbp+rdx]
        movsxd  rdx, esi
        mov     byte [rax+rdx], r14b
        lea     edx, [rcx+6H]
        cmp     ebx, edx
        jle     L_018
        add     edx, edi
        movsxd  rdx, edx
        movzx   r15d, byte [rbp+rdx]
        lea     edx, [rcx+0EH]
        movsxd  r14, edx
        mov     byte [rax+r14], r15b
        lea     r14d, [rcx+7H]
        cmp     ebx, r14d
        jle     L_018
        add     r14d, edi
        cmp     ebx, r13d
        movsxd  r14, r14d
        movzx   r15d, byte [rbp+r14]
        lea     r14d, [rcx+0FH]
        movsxd  r14, r14d
        mov     byte [rax+r14], r15b
        jle     L_018
        add     r13d, edi
        cmp     ebx, r11d
        movsxd  r13, r13d
        movzx   r14d, byte [rbp+r13]
        lea     r13d, [rcx+10H]
        movsxd  r13, r13d
        mov     byte [rax+r13], r14b
        jle     L_018
        add     r11d, edi
        cmp     ebx, r10d
        movsxd  r11, r11d
        movzx   r13d, byte [rbp+r11]
        lea     r11d, [rcx+11H]
        movsxd  r11, r11d
        mov     byte [rax+r11], r13b
        jle     L_018
        add     r10d, edi
        cmp     ebx, r9d
        movsxd  r10, r10d
        movzx   r11d, byte [rbp+r10]
        lea     r10d, [rcx+12H]
        movsxd  r10, r10d
        mov     byte [rax+r10], r11b
        jle     L_018
        add     r9d, edi
        cmp     ebx, r8d
        movsxd  r9, r9d
        movzx   r10d, byte [rbp+r9]
        lea     r9d, [rcx+13H]
        movsxd  r9, r9d
        mov     byte [rax+r9], r10b
        jle     L_018
        add     r8d, edi
        cmp     ebx, esi
        movsxd  r8, r8d
        movzx   r9d, byte [rbp+r8]
        lea     r8d, [rcx+14H]
        movsxd  r8, r8d
        mov     byte [rax+r8], r9b
        jle     L_018
        add     esi, edi
        cmp     ebx, edx
        movsxd  rsi, esi
        movzx   r8d, byte [rbp+rsi]
        lea     esi, [rcx+15H]
        movsxd  rsi, esi
        mov     byte [rax+rsi], r8b
        jle     L_018
        add     edx, edi
        add     ecx, 22
        movsxd  rdx, edx
        movsxd  rcx, ecx
        movzx   edx, byte [rbp+rdx]
        mov     byte [rax+rcx], dl
L_018:  add     r12d, 9
        movsxd  r12, r12d
        mov     byte [rax+r12], 0
        add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   16
L_019:  movsxd  rdi, edi
        xor     ecx, ecx
        add     rbp, rdi




ALIGN   16
L_020:  movzx   edx, byte [rbp+rcx]
        mov     byte [rax+rcx+8H], dl
        add     rcx, 1
        cmp     ebx, ecx
        jg      L_020
        jmp     L_018







ALIGN   16

__string_parseInt:
        movsx   edx, byte [rdi+8H]
        cmp     dl, 45
        jz      L_024
        lea     rcx, [rdi+8H]
        xor     edi, edi
L_021:  lea     eax, [rdx-30H]
        cmp     al, 9
        mov     eax, 0
        ja      L_023




ALIGN   8
L_022:  sub     edx, 48
        lea     rax, [rax+rax*4]
        add     rcx, 1
        movsxd  rdx, edx
        lea     rax, [rdx+rax*2]
        movsx   edx, byte [rcx]
        lea     esi, [rdx-30H]
        cmp     sil, 9
        jbe     L_022
L_023:  mov     rdx, rax
        neg     rdx
        test    edi, edi
        cmovne  rax, rdx
        ret





ALIGN   8
L_024:  lea     rcx, [rdi+9H]
        movsx   edx, byte [rdi+9H]
        mov     edi, 1
        jmp     L_021


        nop

ALIGN   16
__string_ord:
        movsx   rax, byte [rdi+rsi+8H]
        ret







ALIGN   16

__stringConcate:
        push    r15
        push    r14
        push    r13
        push    r12
        mov     r12, rsi
        push    rbp
        mov     rbp, rdi
        push    rbx
        sub     rsp, 8
        mov     rbx, qword [rdi]
        mov     r13, qword [rsi]
        lea     r14, [rbx+r13]
        lea     rdi, [r14+9H]
        call    malloc
        test    rbx, rbx
        mov     qword [rax], r14
        jle     L_026
        lea     rcx, [rbp+8H]
        lea     rdx, [rax+18H]
        lea     rsi, [rbp+18H]
        cmp     rcx, rdx
        lea     rdx, [rax+8H]
        setae   cl
        cmp     rsi, rdx
        setbe   dl
        or      cl, dl
        je      L_029
        cmp     rbx, 15
        jbe     L_029
        mov     rsi, rbx
        xor     ecx, ecx
        xor     edi, edi
        shr     rsi, 4
        mov     rdx, rsi
        shl     rdx, 4
L_025:  movdqu  xmm0, oword [rbp+rcx+8H]
        add     rdi, 1
        movdqu  oword [rax+rcx+8H], xmm0
        add     rcx, 16
        cmp     rsi, rdi
        ja      L_025
        cmp     rbx, rdx
        je      L_026
        lea     r14d, [rdx+8H]
        movsxd  r14, r14d
        movzx   ecx, byte [rbp+r14]
        mov     byte [rax+r14], cl
        lea     ecx, [rdx+1H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r10d, [rdx+9H]
        movsxd  rcx, r10d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+2H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r9d, [rdx+0AH]
        movsxd  rcx, r9d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+3H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     r8d, [rdx+0BH]
        movsxd  rcx, r8d
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+4H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     edi, [rdx+0CH]
        movsxd  rcx, edi
        movzx   esi, byte [rbp+rcx]
        mov     byte [rax+rcx], sil
        lea     ecx, [rdx+5H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     esi, [rdx+0DH]
        movsxd  rcx, esi
        movzx   r11d, byte [rbp+rcx]
        mov     byte [rax+rcx], r11b
        lea     ecx, [rdx+6H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        jle     L_026
        lea     ecx, [rdx+0EH]
        movsxd  r11, ecx
        movzx   r15d, byte [rbp+r11]
        mov     byte [rax+r11], r15b
        lea     r11d, [rdx+7H]
        movsxd  r11, r11d
        cmp     rbx, r11
        jle     L_026
        lea     r11d, [rdx+0FH]
        cmp     rbx, r14
        movsxd  r11, r11d
        movzx   r15d, byte [rbp+r11]
        mov     byte [rax+r11], r15b
        jle     L_026
        lea     r11d, [rdx+10H]
        movsxd  r10, r10d
        cmp     rbx, r10
        movsxd  r11, r11d
        movzx   r14d, byte [rbp+r11]
        mov     byte [rax+r11], r14b
        jle     L_026
        lea     r10d, [rdx+11H]
        movsxd  r9, r9d
        cmp     rbx, r9
        movsxd  r10, r10d
        movzx   r11d, byte [rbp+r10]
        mov     byte [rax+r10], r11b
        jle     L_026
        lea     r9d, [rdx+12H]
        movsxd  r8, r8d
        cmp     rbx, r8
        movsxd  r9, r9d
        movzx   r10d, byte [rbp+r9]
        mov     byte [rax+r9], r10b
        jle     L_026
        lea     r8d, [rdx+13H]
        movsxd  rdi, edi
        cmp     rbx, rdi
        movsxd  r8, r8d
        movzx   r9d, byte [rbp+r8]
        mov     byte [rax+r8], r9b
        jle     L_026
        lea     edi, [rdx+14H]
        movsxd  rsi, esi
        cmp     rbx, rsi
        movsxd  rdi, edi
        movzx   r8d, byte [rbp+rdi]
        mov     byte [rax+rdi], r8b
        jle     L_026
        lea     esi, [rdx+15H]
        movsxd  rcx, ecx
        cmp     rbx, rcx
        movsxd  rsi, esi
        movzx   edi, byte [rbp+rsi]
        mov     byte [rax+rsi], dil
        jle     L_026
        add     edx, 22
        movsxd  rdx, edx
        movzx   ecx, byte [rbp+rdx]
        mov     byte [rax+rdx], cl
L_026:  test    r13, r13
        jle     L_031
        lea     rsi, [r13+1H]
        add     rbx, 8
        mov     edx, 1
        xor     ecx, ecx




ALIGN   8
L_027:  movzx   edi, byte [r12+rdx+7H]
        add     rcx, rax
        mov     byte [rcx+rbx], dil
        mov     rcx, rdx
        add     rdx, 1
        cmp     rdx, rsi
        jnz     L_027
L_028:  add     r13, rax
        mov     byte [r13+rbx], 0
        add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret





ALIGN   8
L_029:  xor     edx, edx




ALIGN   8
L_030:  movzx   ecx, byte [rbp+rdx+8H]
        mov     byte [rax+rdx+8H], cl
        add     rdx, 1
        cmp     rbx, rdx
        jnz     L_030
        jmp     L_026

L_031:  add     rbx, 8
        jmp     L_028







ALIGN   16

__stringCompare:
        sub     rsp, 8
        add     rsi, 8
        add     rdi, 8
        call    strcmp
        add     rsp, 8
        cdqe
        ret



SECTION .data   


SECTION .bss    align=32

__value:
        resq    22472

__has:
        resq    22472

__real_addr:
        resq    108

__buffer.3442:
        resb    1048576


SECTION .text.startup 6

main:
        xor     eax, eax
        jmp     __init



SECTION .rodata.str1.1 

L_032:
        db 25H, 73H, 00H

L_033:
        db 25H, 6CH, 64H, 00H


;=====================================================================
	 section .text
_gcd:
	b0:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 48], rdi
	mov qword [rbp - 184], rsi
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 184]
	idiv rbx
	mov qword [rbp - 40], rdx
	mov rbx, qword [rbp - 40]
	cmp rbx, 0
	je b1
	b2:
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 184]
	idiv rbx
	mov qword [rbp - 160], rdx
	mov rbx, qword [rbp - 184]
	mov r10, rbx
	mov qword [rbp - 64], r10
	mov r10, qword [rbp - 160]
	mov rbx, r10
	mov qword [rbp - 176], rbx
	b3:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 152], rdx
	mov rbx, qword [rbp - 152]
	cmp rbx, 0
	je b4
	b5:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 24], rdx
	mov rbx, qword [rbp - 176]
	mov r10, rbx
	mov qword [rbp - 80], r10
	mov r10, qword [rbp - 24]
	mov rbx, r10
	mov qword [rbp - 104], rbx
	b6:
	mov rax, qword [rbp - 80]
	cdq
	mov rbx, qword [rbp - 104]
	idiv rbx
	mov qword [rbp - 96], rdx
	mov rbx, qword [rbp - 96]
	cmp rbx, 0
	je b7
	b8:
	mov rax, qword [rbp - 80]
	cdq
	mov rbx, qword [rbp - 104]
	idiv rbx
	mov qword [rbp - 200], rdx
	mov rbx, qword [rbp - 104]
	mov r10, rbx
	mov qword [rbp - 16], r10
	mov rbx, qword [rbp - 200]
	mov r10, rbx
	mov qword [rbp - 136], r10
	b9:
	mov rax, qword [rbp - 16]
	cdq
	mov rbx, qword [rbp - 136]
	idiv rbx
	mov qword [rbp - 32], rdx
	mov rbx, qword [rbp - 32]
	cmp rbx, 0
	je b10
	b11:
	mov rax, qword [rbp - 16]
	cdq
	mov rbx, qword [rbp - 136]
	idiv rbx
	mov qword [rbp - 72], rdx
	mov rbx, qword [rbp - 136]
	mov r10, rbx
	mov qword [rbp - 112], r10
	mov rbx, qword [rbp - 72]
	mov r10, rbx
	mov qword [rbp - 8], r10
	b12:
	mov rax, qword [rbp - 112]
	cdq
	mov rbx, qword [rbp - 8]
	idiv rbx
	mov qword [rbp - 56], rdx
	mov rbx, qword [rbp - 56]
	cmp rbx, 0
	je b13
	b14:
	mov rax, qword [rbp - 112]
	cdq
	mov rbx, qword [rbp - 8]
	idiv rbx
	mov qword [rbp - 192], rdx
	mov rsi, qword [rbp - 192]
	mov rdi, qword [rbp - 8]
	call _gcd5
	mov qword [rbp - 120], rax
	mov rax, qword [rbp - 120]
	jmp b15
	b13:
	mov rax, qword [rbp - 8]
	b15:
	mov qword [rbp - 168], rax
	mov rax, qword [rbp - 168]
	jmp b16
	b10:
	mov rax, qword [rbp - 136]
	b16:
	mov qword [rbp - 144], rax
	mov rax, qword [rbp - 144]
	jmp b17
	b7:
	mov rax, qword [rbp - 104]
	b17:
	mov qword [rbp - 88], rax
	mov rax, qword [rbp - 88]
	jmp b18
	b4:
	mov rax, qword [rbp - 176]
	b18:
	mov qword [rbp - 128], rax
	mov rax, qword [rbp - 128]
	jmp b19
	b1:
	mov rax, qword [rbp - 184]
	b19:
	leave
	ret 
_gcd1:
	b20:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 128], rdi
	mov qword [rbp - 80], rsi
	mov rax, qword [rbp - 128]
	cdq
	mov rbx, qword [rbp - 80]
	idiv rbx
	mov qword [rbp - 48], rdx
	mov rbx, qword [rbp - 48]
	cmp rbx, 0
	je b21
	b22:
	mov rax, qword [rbp - 128]
	cdq
	mov rbx, qword [rbp - 80]
	idiv rbx
	mov qword [rbp - 96], rdx
	mov rbx, qword [rbp - 80]
	mov r10, rbx
	mov qword [rbp - 192], r10
	mov r10, qword [rbp - 96]
	mov rbx, r10
	mov qword [rbp - 176], rbx
	b23:
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 56], rdx
	mov rbx, qword [rbp - 56]
	cmp rbx, 0
	je b24
	b25:
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 40], rdx
	mov rbx, qword [rbp - 176]
	mov r10, rbx
	mov qword [rbp - 136], r10
	mov rbx, qword [rbp - 40]
	mov r10, rbx
	mov qword [rbp - 184], r10
	b26:
	mov rax, qword [rbp - 136]
	cdq
	mov rbx, qword [rbp - 184]
	idiv rbx
	mov qword [rbp - 8], rdx
	mov rbx, qword [rbp - 8]
	cmp rbx, 0
	je b27
	b28:
	mov rax, qword [rbp - 136]
	cdq
	mov rbx, qword [rbp - 184]
	idiv rbx
	mov qword [rbp - 200], rdx
	mov r10, qword [rbp - 184]
	mov rbx, r10
	mov qword [rbp - 32], rbx
	mov r10, qword [rbp - 200]
	mov rbx, r10
	mov qword [rbp - 64], rbx
	b29:
	mov rax, qword [rbp - 32]
	cdq
	mov rbx, qword [rbp - 64]
	idiv rbx
	mov qword [rbp - 144], rdx
	mov rbx, qword [rbp - 144]
	cmp rbx, 0
	je b30
	b31:
	mov rax, qword [rbp - 32]
	cdq
	mov rbx, qword [rbp - 64]
	idiv rbx
	mov qword [rbp - 16], rdx
	mov r10, qword [rbp - 64]
	mov rbx, r10
	mov qword [rbp - 72], rbx
	mov rbx, qword [rbp - 16]
	mov r10, rbx
	mov qword [rbp - 88], r10
	b32:
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 88]
	idiv rbx
	mov qword [rbp - 152], rdx
	mov rbx, qword [rbp - 152]
	cmp rbx, 0
	je b33
	b34:
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 88]
	idiv rbx
	mov qword [rbp - 24], rdx
	mov rsi, qword [rbp - 24]
	mov rdi, qword [rbp - 88]
	call _gcd
	mov qword [rbp - 112], rax
	mov rax, qword [rbp - 112]
	jmp b35
	b33:
	mov rax, qword [rbp - 88]
	b35:
	mov qword [rbp - 120], rax
	mov rax, qword [rbp - 120]
	jmp b36
	b30:
	mov rax, qword [rbp - 64]
	b36:
	mov qword [rbp - 104], rax
	mov rax, qword [rbp - 104]
	jmp b37
	b27:
	mov rax, qword [rbp - 184]
	b37:
	mov qword [rbp - 168], rax
	mov rax, qword [rbp - 168]
	jmp b38
	b24:
	mov rax, qword [rbp - 176]
	b38:
	mov qword [rbp - 160], rax
	mov rax, qword [rbp - 160]
	jmp b39
	b21:
	mov rax, qword [rbp - 80]
	b39:
	leave
	ret 
_gcd2:
	b40:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 72], rdi
	mov qword [rbp - 88], rsi
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 88]
	idiv rbx
	mov qword [rbp - 80], rdx
	mov rbx, qword [rbp - 80]
	cmp rbx, 0
	je b41
	b42:
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 88]
	idiv rbx
	mov qword [rbp - 104], rdx
	mov r10, qword [rbp - 88]
	mov rbx, r10
	mov qword [rbp - 136], rbx
	mov r10, qword [rbp - 104]
	mov rbx, r10
	mov qword [rbp - 32], rbx
	b43:
	mov rax, qword [rbp - 136]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 160], rdx
	mov rbx, qword [rbp - 160]
	cmp rbx, 0
	je b44
	b45:
	mov rax, qword [rbp - 136]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 192], rdx
	mov rbx, qword [rbp - 32]
	mov r10, rbx
	mov qword [rbp - 8], r10
	mov r10, qword [rbp - 192]
	mov rbx, r10
	mov qword [rbp - 112], rbx
	b46:
	mov rax, qword [rbp - 8]
	cdq
	mov rbx, qword [rbp - 112]
	idiv rbx
	mov qword [rbp - 24], rdx
	mov rbx, qword [rbp - 24]
	cmp rbx, 0
	je b47
	b48:
	mov rax, qword [rbp - 8]
	cdq
	mov rbx, qword [rbp - 112]
	idiv rbx
	mov qword [rbp - 56], rdx
	mov rbx, qword [rbp - 112]
	mov r10, rbx
	mov qword [rbp - 152], r10
	mov rbx, qword [rbp - 56]
	mov r10, rbx
	mov qword [rbp - 176], r10
	b49:
	mov rax, qword [rbp - 152]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 16], rdx
	mov rbx, qword [rbp - 16]
	cmp rbx, 0
	je b50
	b51:
	mov rax, qword [rbp - 152]
	cdq
	mov rbx, qword [rbp - 176]
	idiv rbx
	mov qword [rbp - 168], rdx
	mov rbx, qword [rbp - 176]
	mov r10, rbx
	mov qword [rbp - 64], r10
	mov r10, qword [rbp - 168]
	mov rbx, r10
	mov qword [rbp - 200], rbx
	b52:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 48], rdx
	mov rbx, qword [rbp - 48]
	cmp rbx, 0
	je b53
	b54:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 184], rdx
	mov rsi, qword [rbp - 184]
	mov rdi, qword [rbp - 200]
	call _gcd1
	mov qword [rbp - 40], rax
	mov rax, qword [rbp - 40]
	jmp b55
	b53:
	mov rax, qword [rbp - 200]
	b55:
	mov qword [rbp - 120], rax
	mov rax, qword [rbp - 120]
	jmp b56
	b50:
	mov rax, qword [rbp - 176]
	b56:
	mov qword [rbp - 96], rax
	mov rax, qword [rbp - 96]
	jmp b57
	b47:
	mov rax, qword [rbp - 112]
	b57:
	mov qword [rbp - 144], rax
	mov rax, qword [rbp - 144]
	jmp b58
	b44:
	mov rax, qword [rbp - 32]
	b58:
	mov qword [rbp - 128], rax
	mov rax, qword [rbp - 128]
	jmp b59
	b41:
	mov rax, qword [rbp - 88]
	b59:
	leave
	ret 
_gcd3:
	b60:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 168], rdi
	mov qword [rbp - 96], rsi
	mov rax, qword [rbp - 168]
	cdq
	mov rbx, qword [rbp - 96]
	idiv rbx
	mov qword [rbp - 184], rdx
	mov rbx, qword [rbp - 184]
	cmp rbx, 0
	je b61
	b62:
	mov rax, qword [rbp - 168]
	cdq
	mov rbx, qword [rbp - 96]
	idiv rbx
	mov qword [rbp - 72], rdx
	mov r10, qword [rbp - 96]
	mov rbx, r10
	mov qword [rbp - 56], rbx
	mov r10, qword [rbp - 72]
	mov rbx, r10
	mov qword [rbp - 104], rbx
	b63:
	mov rax, qword [rbp - 56]
	cdq
	mov rbx, qword [rbp - 104]
	idiv rbx
	mov qword [rbp - 16], rdx
	mov rbx, qword [rbp - 16]
	cmp rbx, 0
	je b64
	b65:
	mov rax, qword [rbp - 56]
	cdq
	mov rbx, qword [rbp - 104]
	idiv rbx
	mov qword [rbp - 176], rdx
	mov r10, qword [rbp - 104]
	mov rbx, r10
	mov qword [rbp - 48], rbx
	mov r10, qword [rbp - 176]
	mov rbx, r10
	mov qword [rbp - 112], rbx
	b66:
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 112]
	idiv rbx
	mov qword [rbp - 192], rdx
	mov rbx, qword [rbp - 192]
	cmp rbx, 0
	je b67
	b68:
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 112]
	idiv rbx
	mov qword [rbp - 80], rdx
	mov r10, qword [rbp - 112]
	mov rbx, r10
	mov qword [rbp - 8], rbx
	mov rbx, qword [rbp - 80]
	mov r10, rbx
	mov qword [rbp - 32], r10
	b69:
	mov rax, qword [rbp - 8]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 40], rdx
	mov rbx, qword [rbp - 40]
	cmp rbx, 0
	je b70
	b71:
	mov rax, qword [rbp - 8]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 88], rdx
	mov rbx, qword [rbp - 32]
	mov r10, rbx
	mov qword [rbp - 64], r10
	mov rbx, qword [rbp - 88]
	mov r10, rbx
	mov qword [rbp - 200], r10
	b72:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 24], rdx
	mov rbx, qword [rbp - 24]
	cmp rbx, 0
	je b73
	b74:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 152], rdx
	mov rsi, qword [rbp - 152]
	mov rdi, qword [rbp - 200]
	call _gcd2
	mov qword [rbp - 136], rax
	mov rax, qword [rbp - 136]
	jmp b75
	b73:
	mov rax, qword [rbp - 200]
	b75:
	mov qword [rbp - 144], rax
	mov rax, qword [rbp - 144]
	jmp b76
	b70:
	mov rax, qword [rbp - 32]
	b76:
	mov qword [rbp - 160], rax
	mov rax, qword [rbp - 160]
	jmp b77
	b67:
	mov rax, qword [rbp - 112]
	b77:
	mov qword [rbp - 120], rax
	mov rax, qword [rbp - 120]
	jmp b78
	b64:
	mov rax, qword [rbp - 104]
	b78:
	mov qword [rbp - 128], rax
	mov rax, qword [rbp - 128]
	jmp b79
	b61:
	mov rax, qword [rbp - 96]
	b79:
	leave
	ret 
_gcd4:
	b80:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 96], rdi
	mov qword [rbp - 152], rsi
	mov rax, qword [rbp - 96]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 160], rdx
	mov rbx, qword [rbp - 160]
	cmp rbx, 0
	je b81
	b82:
	mov rax, qword [rbp - 96]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 48], rdx
	mov rbx, qword [rbp - 152]
	mov r10, rbx
	mov qword [rbp - 64], r10
	mov r10, qword [rbp - 48]
	mov rbx, r10
	mov qword [rbp - 168], rbx
	b83:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 168]
	idiv rbx
	mov qword [rbp - 80], rdx
	mov rbx, qword [rbp - 80]
	cmp rbx, 0
	je b84
	b85:
	mov rax, qword [rbp - 64]
	cdq
	mov rbx, qword [rbp - 168]
	idiv rbx
	mov qword [rbp - 144], rdx
	mov rbx, qword [rbp - 168]
	mov r10, rbx
	mov qword [rbp - 192], r10
	mov rbx, qword [rbp - 144]
	mov r10, rbx
	mov qword [rbp - 24], r10
	b86:
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 24]
	idiv rbx
	mov qword [rbp - 184], rdx
	mov rbx, qword [rbp - 184]
	cmp rbx, 0
	je b87
	b88:
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 24]
	idiv rbx
	mov qword [rbp - 40], rdx
	mov r10, qword [rbp - 24]
	mov rbx, r10
	mov qword [rbp - 72], rbx
	mov rbx, qword [rbp - 40]
	mov r10, rbx
	mov qword [rbp - 56], r10
	b89:
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 56]
	idiv rbx
	mov qword [rbp - 32], rdx
	mov rbx, qword [rbp - 32]
	cmp rbx, 0
	je b90
	b91:
	mov rax, qword [rbp - 72]
	cdq
	mov rbx, qword [rbp - 56]
	idiv rbx
	mov qword [rbp - 104], rdx
	mov rbx, qword [rbp - 56]
	mov r10, rbx
	mov qword [rbp - 88], r10
	mov rbx, qword [rbp - 104]
	mov r10, rbx
	mov qword [rbp - 16], r10
	b92:
	mov rax, qword [rbp - 88]
	cdq
	mov rbx, qword [rbp - 16]
	idiv rbx
	mov qword [rbp - 200], rdx
	mov rbx, qword [rbp - 200]
	cmp rbx, 0
	je b93
	b94:
	mov rax, qword [rbp - 88]
	cdq
	mov rbx, qword [rbp - 16]
	idiv rbx
	mov qword [rbp - 120], rdx
	mov rsi, qword [rbp - 120]
	mov rdi, qword [rbp - 16]
	call _gcd
	mov qword [rbp - 128], rax
	mov rax, qword [rbp - 128]
	jmp b95
	b93:
	mov rax, qword [rbp - 16]
	b95:
	mov qword [rbp - 8], rax
	mov rax, qword [rbp - 8]
	jmp b96
	b90:
	mov rax, qword [rbp - 56]
	b96:
	mov qword [rbp - 136], rax
	mov rax, qword [rbp - 136]
	jmp b97
	b87:
	mov rax, qword [rbp - 24]
	b97:
	mov qword [rbp - 112], rax
	mov rax, qword [rbp - 112]
	jmp b98
	b84:
	mov rax, qword [rbp - 168]
	b98:
	mov qword [rbp - 176], rax
	mov rax, qword [rbp - 176]
	jmp b99
	b81:
	mov rax, qword [rbp - 152]
	b99:
	leave
	ret 
_gcd5:
	b100:
	push rbp
	mov rbp, rsp
	sub rsp, 208
	mov qword [rbp - 192], rdi
	mov qword [rbp - 152], rsi
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 48], rdx
	mov rbx, qword [rbp - 48]
	cmp rbx, 0
	je b101
	b102:
	mov rax, qword [rbp - 192]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 8], rdx
	mov rbx, qword [rbp - 152]
	mov r10, rbx
	mov qword [rbp - 80], r10
	mov rbx, qword [rbp - 8]
	mov r10, rbx
	mov qword [rbp - 32], r10
	b103:
	mov rax, qword [rbp - 80]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 88], rdx
	mov rbx, qword [rbp - 88]
	cmp rbx, 0
	je b104
	b105:
	mov rax, qword [rbp - 80]
	cdq
	mov rbx, qword [rbp - 32]
	idiv rbx
	mov qword [rbp - 16], rdx
	mov rbx, qword [rbp - 32]
	mov r10, rbx
	mov qword [rbp - 112], r10
	mov r10, qword [rbp - 16]
	mov rbx, r10
	mov qword [rbp - 64], rbx
	b106:
	mov rax, qword [rbp - 112]
	cdq
	mov rbx, qword [rbp - 64]
	idiv rbx
	mov qword [rbp - 120], rdx
	mov rbx, qword [rbp - 120]
	cmp rbx, 0
	je b107
	b108:
	mov rax, qword [rbp - 112]
	cdq
	mov rbx, qword [rbp - 64]
	idiv rbx
	mov qword [rbp - 168], rdx
	mov rbx, qword [rbp - 64]
	mov r10, rbx
	mov qword [rbp - 176], r10
	mov rbx, qword [rbp - 168]
	mov r10, rbx
	mov qword [rbp - 96], r10
	b109:
	mov rax, qword [rbp - 176]
	cdq
	mov rbx, qword [rbp - 96]
	idiv rbx
	mov qword [rbp - 136], rdx
	mov rbx, qword [rbp - 136]
	cmp rbx, 0
	je b110
	b111:
	mov rax, qword [rbp - 176]
	cdq
	mov rbx, qword [rbp - 96]
	idiv rbx
	mov qword [rbp - 56], rdx
	mov r10, qword [rbp - 96]
	mov rbx, r10
	mov qword [rbp - 184], rbx
	mov rbx, qword [rbp - 56]
	mov r10, rbx
	mov qword [rbp - 200], r10
	b112:
	mov rax, qword [rbp - 184]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 128], rdx
	mov rbx, qword [rbp - 128]
	cmp rbx, 0
	je b113
	b114:
	mov rax, qword [rbp - 184]
	cdq
	mov rbx, qword [rbp - 200]
	idiv rbx
	mov qword [rbp - 24], rdx
	mov rsi, qword [rbp - 24]
	mov rdi, qword [rbp - 200]
	call _gcd2
	mov qword [rbp - 40], rax
	mov rax, qword [rbp - 40]
	jmp b115
	b113:
	mov rax, qword [rbp - 200]
	b115:
	mov qword [rbp - 144], rax
	mov rax, qword [rbp - 144]
	jmp b116
	b110:
	mov rax, qword [rbp - 96]
	b116:
	mov qword [rbp - 72], rax
	mov rax, qword [rbp - 72]
	jmp b117
	b107:
	mov rax, qword [rbp - 64]
	b117:
	mov qword [rbp - 160], rax
	mov rax, qword [rbp - 160]
	jmp b118
	b104:
	mov rax, qword [rbp - 32]
	b118:
	mov qword [rbp - 104], rax
	mov rax, qword [rbp - 104]
	jmp b119
	b101:
	mov rax, qword [rbp - 152]
	b119:
	leave
	ret 
_main:
	b120:
	push rbp
	mov rbp, rsp
	sub rsp, 528
	mov rbx, 10
	mov qword [rbp - 48], rbx
	mov rbx, 1
	mov qword [rbp - 528], rbx
	b121:
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 528]
	idiv rbx
	mov qword [rbp - 160], rdx
	mov rbx, qword [rbp - 160]
	cmp rbx, 0
	je b122
	b123:
	mov rax, qword [rbp - 48]
	cdq
	mov rbx, qword [rbp - 528]
	idiv rbx
	mov qword [rbp - 304], rdx
	mov rbx, qword [rbp - 528]
	mov r10, rbx
	mov qword [rbp - 464], r10
	mov rbx, qword [rbp - 304]
	mov r10, rbx
	mov qword [rbp - 192], r10
	b124:
	mov rax, qword [rbp - 464]
	cdq
	mov rbx, qword [rbp - 192]
	idiv rbx
	mov qword [rbp - 136], rdx
	mov rbx, qword [rbp - 136]
	cmp rbx, 0
	je b125
	b126:
	mov rax, qword [rbp - 464]
	cdq
	mov rbx, qword [rbp - 192]
	idiv rbx
	mov qword [rbp - 80], rdx
	mov rbx, qword [rbp - 192]
	mov r10, rbx
	mov qword [rbp - 376], r10
	mov rbx, qword [rbp - 80]
	mov r10, rbx
	mov qword [rbp - 336], r10
	b127:
	mov rax, qword [rbp - 376]
	cdq
	mov rbx, qword [rbp - 336]
	idiv rbx
	mov qword [rbp - 224], rdx
	mov rbx, qword [rbp - 224]
	cmp rbx, 0
	je b128
	b129:
	mov rax, qword [rbp - 376]
	cdq
	mov rbx, qword [rbp - 336]
	idiv rbx
	mov qword [rbp - 312], rdx
	mov r10, qword [rbp - 336]
	mov rbx, r10
	mov qword [rbp - 168], rbx
	mov rbx, qword [rbp - 312]
	mov r10, rbx
	mov qword [rbp - 416], r10
	b130:
	mov rax, qword [rbp - 168]
	cdq
	mov rbx, qword [rbp - 416]
	idiv rbx
	mov qword [rbp - 88], rdx
	mov rbx, qword [rbp - 88]
	cmp rbx, 0
	je b131
	b132:
	mov rax, qword [rbp - 168]
	cdq
	mov rbx, qword [rbp - 416]
	idiv rbx
	mov qword [rbp - 448], rdx
	mov rsi, qword [rbp - 448]
	mov rdi, qword [rbp - 416]
	call _gcd
	mov qword [rbp - 328], rax
	mov rax, qword [rbp - 328]
	jmp b133
	b131:
	mov rax, qword [rbp - 416]
	b133:
	mov qword [rbp - 408], rax
	mov rax, qword [rbp - 408]
	jmp b134
	b128:
	mov rax, qword [rbp - 336]
	b134:
	mov qword [rbp - 96], rax
	mov rax, qword [rbp - 96]
	jmp b135
	b125:
	mov rax, qword [rbp - 192]
	b135:
	mov qword [rbp - 344], rax
	mov rax, qword [rbp - 344]
	jmp b136
	b122:
	mov rax, qword [rbp - 528]
	b136:
	mov qword [rbp - 520], rax
	mov rdi, qword [rbp - 520]
	call __toString
	mov qword [rbp - 360], rax
	mov rdi, qword [rbp - 360]
	call __println
	mov rbx, 34986
	mov qword [rbp - 24], rbx
	mov rbx, 3087
	mov qword [rbp - 496], rbx
	b137:
	mov rax, qword [rbp - 24]
	cdq
	mov rbx, qword [rbp - 496]
	idiv rbx
	mov qword [rbp - 456], rdx
	mov rbx, qword [rbp - 456]
	cmp rbx, 0
	je b138
	b139:
	mov rax, qword [rbp - 24]
	cdq
	mov rbx, qword [rbp - 496]
	idiv rbx
	mov qword [rbp - 72], rdx
	mov rbx, qword [rbp - 496]
	mov r10, rbx
	mov qword [rbp - 128], r10
	mov r10, qword [rbp - 72]
	mov rbx, r10
	mov qword [rbp - 144], rbx
	b140:
	mov rax, qword [rbp - 128]
	cdq
	mov rbx, qword [rbp - 144]
	idiv rbx
	mov qword [rbp - 280], rdx
	mov rbx, qword [rbp - 280]
	cmp rbx, 0
	je b141
	b142:
	mov rax, qword [rbp - 128]
	cdq
	mov rbx, qword [rbp - 144]
	idiv rbx
	mov qword [rbp - 40], rdx
	mov rbx, qword [rbp - 144]
	mov r10, rbx
	mov qword [rbp - 56], r10
	mov rbx, qword [rbp - 40]
	mov r10, rbx
	mov qword [rbp - 8], r10
	b143:
	mov rax, qword [rbp - 56]
	cdq
	mov rbx, qword [rbp - 8]
	idiv rbx
	mov qword [rbp - 232], rdx
	mov rbx, qword [rbp - 232]
	cmp rbx, 0
	je b144
	b145:
	mov rax, qword [rbp - 56]
	cdq
	mov rbx, qword [rbp - 8]
	idiv rbx
	mov qword [rbp - 488], rdx
	mov r10, qword [rbp - 8]
	mov rbx, r10
	mov qword [rbp - 384], rbx
	mov rbx, qword [rbp - 488]
	mov r10, rbx
	mov qword [rbp - 264], r10
	b146:
	mov rax, qword [rbp - 384]
	cdq
	mov rbx, qword [rbp - 264]
	idiv rbx
	mov qword [rbp - 440], rdx
	mov rbx, qword [rbp - 440]
	cmp rbx, 0
	je b147
	b148:
	mov rax, qword [rbp - 384]
	cdq
	mov rbx, qword [rbp - 264]
	idiv rbx
	mov qword [rbp - 432], rdx
	mov rsi, qword [rbp - 432]
	mov rdi, qword [rbp - 264]
	call _gcd
	mov qword [rbp - 256], rax
	mov rax, qword [rbp - 256]
	jmp b149
	b147:
	mov rax, qword [rbp - 264]
	b149:
	mov qword [rbp - 216], rax
	mov rax, qword [rbp - 216]
	jmp b150
	b144:
	mov rax, qword [rbp - 8]
	b150:
	mov qword [rbp - 424], rax
	mov rax, qword [rbp - 424]
	jmp b151
	b141:
	mov rax, qword [rbp - 144]
	b151:
	mov qword [rbp - 104], rax
	mov rax, qword [rbp - 104]
	jmp b152
	b138:
	mov rax, qword [rbp - 496]
	b152:
	mov qword [rbp - 248], rax
	mov rdi, qword [rbp - 248]
	call __toString
	mov qword [rbp - 504], rax
	mov rdi, qword [rbp - 504]
	call __println
	mov rbx, 2907
	mov qword [rbp - 272], rbx
	mov rbx, 1539
	mov qword [rbp - 16], rbx
	b153:
	mov rax, qword [rbp - 272]
	cdq
	mov rbx, qword [rbp - 16]
	idiv rbx
	mov qword [rbp - 400], rdx
	mov rbx, qword [rbp - 400]
	cmp rbx, 0
	je b154
	b155:
	mov rax, qword [rbp - 272]
	cdq
	mov rbx, qword [rbp - 16]
	idiv rbx
	mov qword [rbp - 120], rdx
	mov rbx, qword [rbp - 16]
	mov r10, rbx
	mov qword [rbp - 176], r10
	mov r10, qword [rbp - 120]
	mov rbx, r10
	mov qword [rbp - 296], rbx
	b156:
	mov rax, qword [rbp - 176]
	cdq
	mov rbx, qword [rbp - 296]
	idiv rbx
	mov qword [rbp - 320], rdx
	mov rbx, qword [rbp - 320]
	cmp rbx, 0
	je b157
	b158:
	mov rax, qword [rbp - 176]
	cdq
	mov rbx, qword [rbp - 296]
	idiv rbx
	mov qword [rbp - 368], rdx
	mov rbx, qword [rbp - 296]
	mov r10, rbx
	mov qword [rbp - 240], r10
	mov r10, qword [rbp - 368]
	mov rbx, r10
	mov qword [rbp - 152], rbx
	b159:
	mov rax, qword [rbp - 240]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 64], rdx
	mov rbx, qword [rbp - 64]
	cmp rbx, 0
	je b160
	b161:
	mov rax, qword [rbp - 240]
	cdq
	mov rbx, qword [rbp - 152]
	idiv rbx
	mov qword [rbp - 472], rdx
	mov rbx, qword [rbp - 152]
	mov r10, rbx
	mov qword [rbp - 208], r10
	mov rbx, qword [rbp - 472]
	mov r10, rbx
	mov qword [rbp - 288], r10
	b162:
	mov rax, qword [rbp - 208]
	cdq
	mov rbx, qword [rbp - 288]
	idiv rbx
	mov qword [rbp - 352], rdx
	mov rbx, qword [rbp - 352]
	cmp rbx, 0
	je b163
	b164:
	mov rax, qword [rbp - 208]
	cdq
	mov rbx, qword [rbp - 288]
	idiv rbx
	mov qword [rbp - 480], rdx
	mov rsi, qword [rbp - 480]
	mov rdi, qword [rbp - 288]
	call _gcd
	mov qword [rbp - 112], rax
	mov rax, qword [rbp - 112]
	jmp b165
	b163:
	mov rax, qword [rbp - 288]
	b165:
	mov qword [rbp - 392], rax
	mov rax, qword [rbp - 392]
	jmp b166
	b160:
	mov rax, qword [rbp - 152]
	b166:
	mov qword [rbp - 32], rax
	mov rax, qword [rbp - 32]
	jmp b167
	b157:
	mov rax, qword [rbp - 296]
	b167:
	mov qword [rbp - 184], rax
	mov rax, qword [rbp - 184]
	jmp b168
	b154:
	mov rax, qword [rbp - 16]
	b168:
	mov qword [rbp - 512], rax
	mov rdi, qword [rbp - 512]
	call __toString
	mov qword [rbp - 200], rax
	mov rdi, qword [rbp - 200]
	call __println
	mov rax, 0
	b169:
	leave
	ret 
__init:
	b170:
	push rbp
	mov rbp, rsp
	call _main
	leave
	ret 
	section .data
