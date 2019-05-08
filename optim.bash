set -e
cd "$(dirname "$0")"
export M_="java -classpath ./lib/antlr-4.7.2-complete.jar:./bin M_.Main"
#cat > program.cpp   # save everything in stdin to program.txt
$M_
#cat program.asm