; Código LLVM IR gerado pelo compilador Fuelang
; Target: x86_64

declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @malloc(i64)

@.str_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@.str_float = private unnamed_addr constant [4 x i8] c"%f\0A\00", align 1
@.str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str_read_float = private unnamed_addr constant [3 x i8] c"%f\00", align 1
@.str_0 = private unnamed_addr constant [28 x i8] c"Digite o n\FAmero de linhas: \00", align 1
@.str_1 = private unnamed_addr constant [38 x i8] c"Erro: n\FAmero deve ser maior que zero!\00", align 1
@.str_2 = private unnamed_addr constant [2 x i8] c"*\00", align 1
@.str_3 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1

define i32 @main() {
entry:
  %n = alloca i32, align 4
  %linha = alloca i32, align 4
  %coluna = alloca i32, align 4
  store i32 0, i32* %n, align 4
  %r0 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([28 x i8], [28 x i8]* @.str_0, i64 0, i64 0))
  %r1 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str_read_int, i64 0, i64 0), i32* %n)
  %r2 = load i32, i32* %n, align 4
  %r4 = icmp sle i32 %r2, 0
  %r3 = zext i1 %r4 to i32
  %r5 = icmp eq i32 %r3, 0
  br i1 %r5, label %L0, label %continue0

continue0:
  %r6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([38 x i8], [38 x i8]* @.str_1, i64 0, i64 0))
  br label %L1

L0:
  store i32 1, i32* %linha, align 4

L2:
  %r7 = load i32, i32* %linha, align 4
  %r8 = load i32, i32* %n, align 4
  %r10 = icmp sle i32 %r7, %r8
  %r9 = zext i1 %r10 to i32
  %r11 = icmp eq i32 %r9, 0
  br i1 %r11, label %L3, label %continue1

continue1:
  store i32 1, i32* %coluna, align 4

L4:
  %r12 = load i32, i32* %coluna, align 4
  %r13 = load i32, i32* %linha, align 4
  %r15 = icmp sle i32 %r12, %r13
  %r14 = zext i1 %r15 to i32
  %r16 = icmp eq i32 %r14, 0
  br i1 %r16, label %L5, label %continue2

continue2:
  %r17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str_2, i64 0, i64 0))
  %r18 = load i32, i32* %coluna, align 4
  %r19 = add i32 %r18, 1
  store i32 %r19, i32* %coluna, align 4
  br label %L4

L5:
  %r20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str_3, i64 0, i64 0))
  %r21 = load i32, i32* %linha, align 4
  %r22 = add i32 %r21, 1
  store i32 %r22, i32* %linha, align 4
  br label %L2

L3:

L1:
  br label %end_program

end_program:
  ret i32 0
}
