# プログラム
## プログラム全体のASTの出力
```
[] of 宣言|式
```
プログラム全体は上記のように出力する  

# 宣言
## 関数宣言
```
{:kind "Funcdef"
 :name String
 :type [] of 引数，返値の型
 :parm [] of 引数宣言
 :body [] of 宣言 | 式 | 状態文
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
関数宣言は上記のように出力する  
nameには，関数の名前を出力する  
loc-begin，loc-endのStringはファイル名を，Intには行番号，列番号の順に出力する  
また，記憶クラス指定子が定義されている場合```:指定子 true```と出力する  

## 引数宣言
```
{:kind "Parm"
 :name String
 :type [] of 型
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
引数宣言は上記のように出力する  
nameには，引数の名前を出力する  
loc-begin，loc-endのStringはファイル名を，Intには行番号，列番号の順に出力する  

## 構造体宣言
```
{:kind "Struct"
 :name String
 :Member [] of メンバー変数宣言
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
構造体宣言は上記のように出力する  
nameには，構造体の名前を出力する  
loc-begin，loc-endのStringはファイル名を，Intには行番号，列番号の順に出力する  

## 共用体宣言  
```
{:kind "Uniondef"
 :name String
 :Member [] of メンバー変数宣言
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
共用体宣言は上記のように出力する  
nameには，共用体の名前を出力する  
loc-begin，loc-ednのStringはファイル名を，Intには行番号，列番号の順に出力する  

## メンバー変数宣言
```
{:kind "Field"
 :name String
 :scope "member"
 :type [] of 型
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
メンバー変数宣言は上記のように出力する  
nameには，メンバー変数の名前を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 変数宣言
```
{:kind "Var"
 :name String
 :scope "local" | "global"
 :DisplayType String
 :type [] of 型
 :init {} of 整数リテラル | 文字リテラル | 浮動小数点リテラル | 式
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
変数宣言は上記のように出力する  
nameには，変数名を出力する  
DisplayTypeは，プログラム中に記述された型を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

# 式
## 三項演算式
```
{:kind "conditionalop"
 :type [] of 型
 :operand1 [] of 変数，関数の参照 | 二項演算式 | 単項演算式
 :operand2 [] of 変数，関数の参照 | 二項演算式 | 単項演算式
 :operand3 [] of 変数，関数の参照 | 二項演算式 | 単項演算式
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
三項演算は上記のように出力する  
operand1は，三項演算子の条件式を出力する  
operand2は，演算結果がthenの場合の処理を出力する  
operand3は，演算結果がelseの場合の処理を出力する  
loc-begin，lob-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 二項演算式
```
{:kind "Binop"
 :op operater
 :type [] of 型
 :LHS {} of 変数，関数の参照 | 二項演算式 | 単項演算式
 :RHS {} of 変数，関数の参照 | 二項演算式 | 単項演算式
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
二項演算は上記のように出力する  
opでは，二項演算子を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 単項演算式
```
{:kind "Unop"
 :op operater
 :type [] of 変数，関数の参照 | 二項演算式 | 単項演算式 
 :HS {} of 変数，関数の参照 | 二項演算式 | 単項演算式
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
単項演算は上記のように出力する  
opでは，単項演算子を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## sizeof演算子
```
{:kind "sizeOf"
 :Parm [] of 変数，関数の参照
 :type [] of 返す値の型
 :loc-begin [String Int Int]
 :lob-end [String Int Int]
}
```
sizeof演算子は上記のように出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## 配列への代入式
```
{:kind "ArrayRef"
 :type [] of 型 
 :Array [] of 
 :Index {} of 
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
配列への代入式は上記のように出力される  
typeでは，代入する型情報を出力する  
Arrayは，代入される配列の情報を出力する  
Indexは，配列の参照するインデックスの情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 関数呼び出し
```
{:kind "FuncCall
 :Func []
 :Parm []
 :type []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
関数呼び出しは上記のように出力される  
Funcは，呼び出す関数の情報を出力する  
Parmは，関数呼び出しの際の引数の情報を出力する  
typeは，関数の型情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 明示的，暗黙的なキャスト
```
:type [{:kind type}{:kind type}]
```
明示的，暗黙的キャストは上記のようにtypeに出力される  
kindのtypeは，型typeが出力される  
typeの左が元の型を出力し，右に行くほどキャストされた型を出力する  

## 変数，関数の参照
```
{:kind "DRE"
 :name String
 :type []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
変数，関数を参照は上記のように出力される  
ただし，変数の場合は```:scope "global" | "local"```も追加で出力する  
nameは，変数，関数名が出力される  
typeは，型情報，関数であれば関数の情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 構造体のメンバー参照
```
{:kind "struct"
 :struct []
 :structmember {}
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
構造体のメンバー参照は上記のように出力される  
structは，参照するメンバーが属する構造体の情報を出力する  
structmemberは，参照するメンバーの情報を出力する  
lob-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 整数リテラル
```
{:kind "IntegerLiteral"
 :value integer
 :type []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
整数リテラルは上記のように出力される  
valueは，整数の数値を出力する  
typeでは，valueで表す型の情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 文字リテラル
```
{:kind "CharacterLiteral"
 :value character
 :type []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
文字リテラルは上記のように出力される  
valueは，文字を出力する  
typeでは，valueで表す型の情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

## 浮動小数点リテラル
```
{:kind "FloatingLiteral"
 :value floating
 :type []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
浮動小数点リテラルは上記のように出力される  
valueは，少数を出力する  
typeでは，valueで表す型の情報を出力する  
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する  

# 状態文
## label
```
{:kind "Label"
 :name String
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
labelは上記のように出力される
nameは，labelの名前が出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## case
```
{:kind "Case"
 :value {}
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
caseは上記のように出力される
valueは，caseの値の情報を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## if文
```
{:kind "If"
 :condition {}
 :then []
 :else []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
if文は上記のように出力される
conditionは，if文の条件式を出力する
thenは，if文のthenの処理を出力する
elseは，if文のelseの処理を出力する
elseの処理が省略されている場合は出力されない
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## switch文
```
{:kind "Switch"
 :condition {}
 :body []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
switch文は上記のように出力される
conditionは，switch文の条件式を出力する
bodyは，switch文の処理を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## while文
```
{:kind "While"
 :condition {}
 :body []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
while文は上記のように出力される
conditionは，while文の条件式を出力する
bodyは，while文で繰り返す処理を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## do文
```
{:kind "Do"
 :condition {}
 :body []
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
do文は上記のように出力される
conditionは，do文の条件式を出力する
bodyは，繰り返される処理を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## for文
```
{:kind "For"
 :init []
 :condition {}
 :update []
 :body []
 :loc-being [String Int Int]
 :loc-end [String Int Int]
}
```
for文は上記のように出力される
initは，初期値を出力する
conditionは，for文の条件式を出力する
updateは，更新式を出力する
bodyは，繰り返される処理を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## goto文
```
{:kind "Goto"
 :goto {}
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
goto文は上記のように出力される
gotoは，ジャンプ先のlabe情報を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## continue
```
{:kind "Continue"
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
continueは上記のように出力される
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## break
```
{:kind "Break"
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
breakは上記のように出力される
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する

## return文
```
{:kind "Ret"
 :value {}
 :loc-begin [String Int Int]
 :loc-end [String Int Int]
}
```
return文は上記のように出力される
valueは，返す値の情報を出力する
loc-begin，loc-endのStringはファイル名，Intには行番号，列番号の順に出力する
