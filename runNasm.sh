nasm -felf64 program.asm
gcc -no-pie -fno-pie -g program.o
./a.out
