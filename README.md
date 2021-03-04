# Строительные блоки Spring

+ Реализовать и сконфигурировать сервисы в tracker-core.

    + 1 Сервис GPS должен иметь следующие параметры:

        + 1.1 каждую секунду (или минуту, как определено в настройке) эмулировать значения текущей широты, долготы, азимута и мгновенной скорости (так же как это делают настоящие приборы GPS);

        + 1.2 помещать значения широты, долготы, азимута и мгновенной скорости в очередь, предоставляемую Сервисом хранения.

        + 1.3 Задание повышенной сложности! Самостоятельно разобраться с библиотекой работающей с GPS-треками.

            + 1.3.1 Треки можно взять например здесь: https://www.gpslib.ru/tracks/index.php?q=&author=v_savin&type=&country=.

            + 1.3.2 Адрес библиотеки: https://labs.micromata.de/projects/jak.html (есть на mvnrepository.com).

    + 2 Сервис хранения сообщений должен выполнять следующие функции:

        + 2.1 предоставлять интерфейс для записи текущих параметров транспорта (GPS), а также для извлечения параметров в том же порядке, в каком они были записаны. На данный момент внутренняя реализация предполагает использование блокирующей очереди.

    + 3 Сервис отправки сообщений должен выполнять следующие функции:

        + 3.1 каждую минуту (периодичность – опция настройки) отправлять накопленные данные на центральный сервер в формате json (пока реальная отправка не делается, объект забирается из очереди Сервиса хранения и содержание объекта выводится в лог в формате json).