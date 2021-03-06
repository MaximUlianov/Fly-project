# UML Diagramms
### Содержание
1. [Диаграмма прецедентов](#1) <br>
  1.1. [Актеры](#1.1) <br>
  1.2. [Варианты использования](#1.2) <br>
	  1.2.1. [Выбор рейса](#1.2.1) <br>
	  1.2.2. [Регистрация](#1.2.2) <br>
	  1.2.3. [Ввод дополнительной информации о багаже](#1.2.3) <br>
	  1.2.4. [Просмотр заказа](#1.2.4) <br>
	  1.2.5. [Подтверждение заказа](#1.2.5) <br>
2. [Диаграммы активности](#2) <br>
  2.1. [Выбор рейса](#2.1) <br>
  2.2. [Регистрация](#2.2) <br>
  2.3. [Ввод дополнительной информации о багаже](#2.3) <br>
  2.4. [Просмотр заказа](#2.4) <br>
  2.5. [Подтверждение заказа](#2.5) <br>
3. [Диаграмма последовательности](#3) <br>
4. [Диаграммы состояний](#4) <br>
	4.1. [Выбор рейса](#4.1) <br>
	4.2. [Информация о дополнительном багаже](#4.2) <br>
	4.3. [Регистрация на рейс](#4.3) <br>
	4.4. [Панель поиска](#4.4) <br>
5. [Диаграммы классов](#5) <br>
	5.1 [Backend](#5.1) <br>
	5.2 [Security](#5.2) <br>
	5.3	[Database](#5.3) <br>
6. [Диаграмма компонентов и развертывания](#6) <br>
 
### 1. Диаграмма прецедентов <a name="1"></a> 
![UseCase](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/useCase/Use%20Case.jpg)
#### 1.1. Актеры <a name="1.1"></a>
| Актёр | Описание | 
|:---|:---|
| Пользователь | Человек, которому нужно заказать билет на определенный рейс |
| Skyscanner API | Внешняя система, которая предоставляет доступные рейсы |

#### 1.2. Варианты использования <a name="1.2"></a>
##### 1.2.1. Поток событий для прецедента "Выбор рейса" <a name="1.2.1"></a>:

**Описание**:
Вариант использования "Выбор рейса" позволяет пользователю выбрать наиболее удобный для него рейс.

**Предусловия**:
Действие происходит, когда пользователь вводит информацию о пункте вылета и назначеня, а также дату отправления и нажимает кнопку <GO>.

**Поток событий**: <br>
Основной поток <<Просмотр рейсов>>:
 1. Система загружает доступные рейсы исходя из введенных пользователем критерий.
 2. Система отображает информацию о рейсах:
  - Время вылета и прибытия
  - Название перевозщика
  - Стоимость одного билета
 3. Пользователь выбирает для себя наиболее подходящий рейс и нажимает на кнопку <Buy>.
 4. Выполнение переходит на следующий этап "Регистрация".
 5. Конец.
 
Альтернативный поток <<Фильтрация рейсов>>:
 1. Пользователь вводит информацию о месте отправления и прибытия, даты вылета туда и обратно.
 2. Пользователь вводит данные о времени вылета и прибытия.
 3. Выполнение переходит на основной поток "Просмотр рейсов".
 4. Конец.
 
 Альтернативный поток <<Поиск рейсов>>:
 1. Пользователь вводит информацию о месте отправления и прибытия, даты вылета. 
 2. Внешняя система Skyscanner API предоставляет информацию о доступных рейсах.
 3. Выполнение переходит на основной поток "Просмотр рейсов".
 4. Конец.
 
##### 1.2.2. Поток событий для прецедента "Регистрация" <a name="1.2.2"></a>:

**Описание**:
Вариант использования "Регистрация" позволяет пользователю ввести необходимые личные данные для заказа билетов.

**Предусловия**:
Действие происходит после того, как пользователь на этапе "Просмотр рейсов" нажал кнопку <Buy>.

**Поток событий**: <br>
Основной поток:
1. Пользователь вводит следующие данные в соответсвующие поля:
  - Имя.
  - Фамилия.
  - Дата рождения.
  - Номер паспорта.
  - Пароль.
  - Свой контактный e-mail. <br>
 **Заметка**: все поля во время ввода валидируются системой и в случае ошибки будет показано соответсвующее сообщение.
2. Пользователь нажимает на кнопку "Proceed registration".
3. Выполнение переходит на основной поток прецедента "Ввод дополнительной иформации о багаже". 
4. Конец.

##### 1.2.3. Поток событий для прецедента "Ввод дополнительной информации о багаже" <a name="1.2.3"></a>: 

**Описание**:
Вариант использования "Ввод дополнительной информации о багаже" позволяет пользователю ввести данные о количестве дополнительного багажа.

**Предусловия**:
Действие происходит после того, как пользователь:
1. В случае, если регистрация выполнена ранее, нажал на кнопку "Buy" на этапе выбора рейса.
2. Если нет, то действие происходит после нажатия на кнопку "Proceed registration" на этапе "Регистрация".

**Поток событий**: <br>
Основной поток:
1. Пользователь вводит количество дополнительного багажа в килограммах.
2. Система выполняет вычисление его стоимости.
3. Пользователь нажимает кнопку "Proceed":
  - Система добавляет стоимость багажа к стоимости билета.
  - Выполнение переходит на основной поток прецедента "Просмотр заказа".
4. Конец.

##### 1.2.4. Поток событий для прецедента "Просмотр заказа" <a name="1.2.4"></a>: 

**Описание**:
Вариант использования "Просмотр заказа" позволяет пользователю просмотреть все данные, выбранные и введенные им во время оформления.

**Предусловия**:
Действие происходит после того, как пользователь нажал кнопку "Proceed" на этапе "Ввод дополнительной информации о багаже".

**Поток событий**: <br>
Основной поток:
1. Система выводит на экран следующую информацию:
  - О выбранном рейсе.
  - О введенных пользователем личных данных.
  - О количестве дополнительного багажа.
2. Пользователь проверяет информацию и нажимает на кнопку "Pay".
3. Выполнение переходит на основной поток прецедента "Подтверждение заказа".
4. Конец.

##### 1.2.5. Поток событий для прецедента "Подтверждение заказа" <a name="1.2.5"></a>: 

**Описание**:
Вариант использования "Подтверждение заказа" позволяет отправлять пользователю заказанные билеты на e-mail и продолжить заказ билетов.

**Предусловия**:
Действие происходит после того, как пользователь нажал на конопку "Pay" на этапе "Просмотр заказа".

**Поток событий**: <br>
Основной поток:
1. Система выводит на экран сообщение о том, что заказ был успешно завершен.
2. Система отправляет билеты на указанный при регистрации e-mail.
3. Пользователь нажимает на кнопку "Continue to order".
4. Выполнение переходит на основной поток прецедента "Выбор рейса".
5. Конец.

### 2. Диаграммы активности <a name="2"></a>

#### 2.1. Выбор рейса <a name="2.1"></a>
Пользователь вводит данные о месте вылета и прибытия, а также дату отправления. Внешнее API ищет доступные рейсы и выводит их на экран. Если пользователю требуется более детальная фильтрация, он может задать время отправления и прибытия.<br>
![FlightSelection](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/activity/1_FlightSelection.jpg)
#### 2.2. Регистрация <a name="2.2"></a>
Пользователь заполняет все необходимые поля. Одновременно с этим система их валидирует и в случае ошибки выводит соответствующее сообщение.<br>
![Registration](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/activity/2_Registration.jpg)
#### 2.3. Ввод дополнительной информации о багаже <a name="2.3"></a>
Если у пользователя есть дополнительный багаж для перевозки, он вводит его вес. Система подсчитывает стоимость транспортировки. Если нет, то выполняется переход на просмотр заказа.<br>
![Extra](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/activity/3_Extra.jpg)
#### 2.4. Просмотр заказа <a name="2.4"></a>
Система выводит на экран информацию о заказе и данных пользователя. При нажатии на "Pay" выполняется переход на подтверждение заказа.<br>
![ReviewOrder](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/activity/4_Review%20order.jpg)
#### 2.5. Подтверждение заказа <a name="2.5"></a>
Система показывает сообщение, что заказ успешно выполнен и отправляет билеты на e-mail пользователя. При нажатии на "Continue to order", выполняется переход на выбор рейса. <br>
![Confirmation](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/activity/5_Confirmation.jpg)
 
### 3. Диаграмма последовательности <a name="3"></a>
![Sequence](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/sequence/Sequence%20Diagram.jpg)

### 4. Диаграммы состояний <a name="4"></a>
#### 4.1. Выбор рейса <a name="4.1"></a>
Окно выбора рейса <br>
https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/mockups/Page_2.png
![FlightSelection](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/state/Choose%20flight.jpg)
#### 4.2. Информация о дополнительном багаже <a name="4.2"></a>
Окно ввода дополнительныой информации о багаже <br>
https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/mockups/Page_4.png
![Extras](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/state/Extras.jpg)
#### 4.3. Регистрация на рейс <a name="4.3"></a>
Окно регистрации <br>
https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/mockups/Page_3.png
![Registration](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/state/Registration.jpg)
#### 4.4. Панель поиска <a name="4.4"></a>
Пример окна с панелью поиска рейсов <br>
https://github.com/MaximUlianov/Fly-project/blob/master/documentation/mockups/Page_1.png
![SearchPane](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/state/Search%20pane%20header.jpg)

### 5. Диаграммы классов <a name="5"></a>
#### 5.1. Backend <a name="5.1"></a>
![Backend](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/class/Backend%20class%20diagram.jpg)
#### 5.2. Security <a name="5.2"></a>
![Security](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/class/Security%20classes%20diagram.jpg)
#### 5.3. Database <a name="5.3"></a>
![Database](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/class/Database%20classes%20diagram.jpg)
 
### 6. Диаграмма компонентов и развертывания <a name="6"></a>
![Deployment&Components](https://raw.githubusercontent.com/MaximUlianov/Fly-project/master/documentation/diagrams/deployment/Deployment%20diagram.jpg)