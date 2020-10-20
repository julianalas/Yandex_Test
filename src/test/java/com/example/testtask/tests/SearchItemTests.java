package com.example.testtask.tests;

import com.example.testtask.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchItemTests extends TestBase{

    @Test
    public void testItem() throws InterruptedException {

        app.getMainPage().goToMarket();
        app.getMainPage().switchToNextTab();
        app.getMarketHeader().selectComputersDepartment();

        app.getMarketItem().filterItem(new Item()
                .setItemType("planshety")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));

        Thread.sleep(2000);

        String itemName = app.getMarketItem().getItemNameFromListByOrder(2);

        app.getMarketHeader().searchItemFromSearchBox(itemName);

        Thread.sleep(2000);

        String foundItemName = app.getMarketItem().getItemNameFromListByOrder(1);

        Assert.assertEquals(foundItemName, itemName);


    }

}

/* Автоматизировать следующий сценарий:
1. Открыть браузер и развернуть на весь экран.
2. Зайти на yandex.ru.
3. Перейти на Яндекс Маркет
4. Выбрать раздел  Компьютеры
5. Выбрать раздел Планшеты
6. Зайти в расширенный поиск
7. Задать параметр поиска от 20000 до 35000 рублей.
8. Выбрать производителя “Apple”
9. Применить условия поиска
10. Запомнить второй элемент в результатах поиска
11. В поисковую строку ввести запомненное значение.
12. Найти и проверить, что наименование товара соответствует запомненному
значению.
*/
