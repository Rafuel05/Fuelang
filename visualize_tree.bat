@echo off
java -cp "lib\antlr-4.13.1-complete.jar;grammar" org.antlr.v4.gui.TestRig Fuelang programa -gui %1
