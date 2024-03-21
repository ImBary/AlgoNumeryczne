#!/bin/bash

cd ~/AlgoNumeryczne/Zadanie1/src
echo 1
javac Main.java
java Main
echo 2
cd ..
echo 3
Rscript creatingPlots.R
echo 4
echo -e '\n' | pdflatex Prezentacja.tex 
echo 5
rm *.log
rm *.aux
