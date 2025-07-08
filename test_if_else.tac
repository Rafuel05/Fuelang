# Código Intermediário (TAC) gerado para test_if_else.tac
# Formato: operador resultado, arg1, arg2

  0: x = 5
  1: _t0 = x > 3
  2: se_falso _t0 desviar L0
  3: imprimir "x is greater than 3\n"
  4: _t1 = x > 10
  5: se_falso _t1 desviar L2
  6: imprimir "x is also greater than 10\n"
  7: desviar L3
  8: L2:
  9: imprimir "x is not greater than 10\n"
 10: L3:
 11: desviar L1
 12: L0:
 13: imprimir "x is not greater than 3\n"
 14: L1:
 15: imprimir "End of program\n"
