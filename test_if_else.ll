; Código LLVM IR gerado pelo compilador Fuelang
; Target: x86_64

declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @malloc(i64)

@.str_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@.str_float = private unnamed_addr constant [4 x i8] c"%f\0A\00", align 1
@.str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str_read_float = private unnamed_addr constant [3 x i8] c"%f\00", align 1
@.str_0 = private unnamed_addr constant [21 x i8] c"x is greater than 3\0A\00", align 1
@.str_1 = private unnamed_addr constant [27 x i8] c"x is also greater than 10\0A\00", align 1
@.str_2 = private unnamed_addr constant [26 x i8] c"x is not greater than 10\0A\00", align 1
@.str_3 = private unnamed_addr constant [25 x i8] c"x is not greater than 3\0A\00", align 1
@.str_4 = private unnamed_addr constant [16 x i8] c"End of program\0A\00", align 1

define i32 @main() {
entry:
  %x = alloca i32, align 4
  store i32 5, i32* %x, align 4
  %r0 = load i32, i32* %x, align 4
  %r2 = icmp sgt i32 %r0, 3
  %r1 = zext i1 %r2 to i32
  %r3 = icmp eq i32 %r1, 0
  br i1 %r3, label %L0, label %continue0

continue0:
  %r4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([21 x i8], [21 x i8]* @.str_0, i64 0, i64 0))
  %r5 = load i32, i32* %x, align 4
  %r7 = icmp sgt i32 %r5, 10
  %r6 = zext i1 %r7 to i32
  %r8 = icmp eq i32 %r6, 0
  br i1 %r8, label %L2, label %continue1

continue1:
  %r9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([27 x i8], [27 x i8]* @.str_1, i64 0, i64 0))
  br label %L3

L2:
  %r10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([26 x i8], [26 x i8]* @.str_2, i64 0, i64 0))

L3:
  br label %L1

L0:
  %r11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([25 x i8], [25 x i8]* @.str_3, i64 0, i64 0))

L1:
  %r12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([16 x i8], [16 x i8]* @.str_4, i64 0, i64 0))
  br label %end_program

end_program:
  ret i32 0
}
