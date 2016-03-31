RULES="exp31 exp32 exp35 exp36 exp40 exp44 exp45"

JAR=../astgrep/target/uberjar/astgrep-0.1.0-SNAPSHOT-standalone.jar 
RULEDIR=../rules/cert
TARGET=mod_rewrite.ast

ASTGREP="java -jar $JAR"

TMPRULE=`mktemp`.clj

for r in $RULES
do
    if [ -f $RULEDIR/$r/$r-expand.clj ]
    then
	rule=$RULEDIR/$r/$r-expand.clj
    else
	rule=$RULEDIR/$r/$r.clj
    fi

    echo "$r line " `wc -l $rule | awk '{print $1}'`
    echo "$r rules " `grep defrule $rule| wc -l`
    if grep nest $rule > /dev/null; then

	echo "$r nest 1"
        sed -e 's/#nest/#nest #use/g' $rule > $TMPRULE
	echo "$r nesttraverse " `$ASTGREP $TMPRULE $TARGET | wc -l`
    else
	echo "$r nest 0"
	echo "$r nesttraverse 0"
    fi
    /usr/bin/time -f "$r time %U" $ASTGREP $rule $TARGET

    rm -f $TMPRULE
done

