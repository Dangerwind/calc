## Консольный калькулятор

Калькулятор запускающийся из консоли. Мой первый собственный пет-проект на Java.
Калькулятор понимает скобки! Можно написать большое выражение и калькулятор сам найдет, что надо вначале считать, что потом и по правилам математики все посчитает.

Sercher.serchMain - находит все * и / которые надо впервую очередь считать

Sercher.searchBrMain - находит выражения в скобках


Repository - репозитория для хранения формулы и логов


Chechker.CheckSymbols - проверка чтобы все цифры были цифрами

Chechker.SignAndBrackets - проверяет на неправильные сочетания скобок

Chechker.CheckBrackets - проверяет на правильность чтобы все скобки открывались и закрывались



Calculate.SymplCalc - делает просыте вычисления без учета скобок

Calculate.FinalCalc - собирает все методы и проходит по всей формуле


**недостатки**
1) нет проверки на 0 при делении
2) может быть я что-то очень сложно сделал но пока что работает


Склонируйте и запустите программу:
```
git clone https://github.com/Dangerwind/calc.git
make build
make run
````

<hr>

![](https://github.com/Dangerwind/calc/blob/90344c87ed7174294a301e1259205f8d516603a1/img/math1.png)

![](https://github.com/Dangerwind/calc/blob/90344c87ed7174294a301e1259205f8d516603a1/img/math2.png)

