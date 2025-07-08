; Código LLVM IR gerado pelo compilador Fuelang
; Target: x86_64

declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @malloc(i64)

@.str_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@.str_float = private unnamed_addr constant [4 x i8] c"%f\0A\00", align 1
@.str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str_read_float = private unnamed_addr constant [3 x i8] c"%f\00", align 1
@.str_0 = private unnamed_addr constant [7 x i8] c"Loop: \00", align 1
@.str_1 = private unnamed_addr constant [2 x i8] c"\0A\00", align 1
@.str_2 = private unnamed_addr constant [7 x i8] c"Done!\0A\00", align 1

define i32 @main() {
entry:
  %i = alloca i32, align 4
  store i32 1, i32* %i, align 4
  br label %L0
L0:
  %r0 = load i32, i32* %i, align 4
  %r2 = icmp sle i32 %r0, 3
  %r1 = zext i1 %r2 to i32
  %r3 = icmp eq i32 %r1, 0
  br i1 %r3, label %L1, label %continue0

continue0:
  %r4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str_0, i64 0, i64 0))
  %r6 = load i32, i32* %i, align 4
  %r5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_int, i64 0, i64 0), i32 %r6)
  %r7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str_1, i64 0, i64 0))
  %r8 = load i32, i32* %i, align 4
  %r9 = add i32 %r8, 1
  store i32 %r9, i32* %i, align 4
  br label %L0
L1:
  %r10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str_2, i64 0, i64 0))
  br label %end_program

end_program:
  ret i32 0
}
