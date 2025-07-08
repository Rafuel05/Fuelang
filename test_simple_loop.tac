# Código Intermediário (TAC) gerado para test_simple_loop.tac
# Formato: operador resultado, arg1, arg2

  0: i = 1
  1: L0:
  2: _t0 = i <= 3
  3: se_falso _t0 desviar L1
  4: imprimir "Loop: "
  5: imprimir i
  6: imprimir "\n"
  7: _t1 = i + 1
  8: i = _t1
  9: desviar L0
 10: L1:
 11: imprimir "Done!\n"
