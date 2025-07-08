# Código Intermediário (TAC) gerado para test_loop.tac
# Formato: operador resultado, arg1, arg2

  0: n = 0
  1: imprimir "Digite o número de linhas: "
  2: ler n
  3: _t0 = n <= 0
  4: se_falso _t0 desviar L0
  5: imprimir "Erro: número deve ser maior que zero!"
  6: desviar L1
  7: L0:
  8: linha = 1
  9: L2:
 10: _t1 = linha <= n
 11: se_falso _t1 desviar L3
 12: coluna = 1
 13: L4:
 14: _t2 = coluna <= linha
 15: se_falso _t2 desviar L5
 16: imprimir "*"
 17: _t3 = coluna + 1
 18: coluna = _t3
 19: desviar L4
 20: L5:
 21: imprimir "\n"
 22: _t4 = linha + 1
 23: linha = _t4
 24: desviar L2
 25: L3:
 26: L1:
