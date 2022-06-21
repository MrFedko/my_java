package homeWork_classes;

import java.time.LocalDate;

class productGeneral {
    private String name;
    private int price;
    private int amount;
    private String unit;

    protected String getInfo() {
        return String.format("Название: %s \nЦена: %d \nКоличество: %d %s", name, price, amount, unit);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    /**
     * set info about product
     * 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     */
    public void setInfo(String name, int price, int amount, String unit) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.unit = unit;
    }
}

class food extends productGeneral {
    private String bestBeforeDate;

    protected String getInfo() {
        return String.format("%s \nСрок годности: %s", super.getInfo(), bestBeforeDate);
    }

    /**
     * set info about food
     * 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     * @param best   срок годности
     */
    public void setInfo(String name, int price, int amount, String unit, String best) {
        super.setInfo(name, price, amount, unit);
        this.bestBeforeDate = best;
    }
}

class drink extends productGeneral {
    private Double volume;

    protected String getInfo() {
        return String.format("%s \nОбъём: %s", super.getInfo(), volume);
    }

    /**
     * set info about food
     * 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     * @param volume объем
     */
    public void setInfo(String name, int price, int amount, String unit, Double volume) {
        super.setInfo(name, price, amount, unit);
        this.volume = volume;
    }
}

class hygieneItems extends productGeneral {
    private int numberOfPieces;

    protected String getInfo() {
        return String.format("%s \nКоличество единиц в упаковке: %d", super.getInfo(), numberOfPieces);
    }

    /**
     * set info about food
     * 
     * @param name           Название продукта
     * @param price          цена
     * @param amount         количество
     * @param unit           единица измерения
     * @param numberOfPieces количество единиц
     */
    public void setInfo(String name, int price, int amount, String unit, int numberOfPieces) {
        super.setInfo(name, price, amount, unit);
        this.numberOfPieces = numberOfPieces;
    }
}

class children extends productGeneral {
    private int minAge;
    private Boolean hypoallergenic;

    protected String getInfo() {
        return String.format("%s \nМинимальный возраст: %d \nГипоаллергенный: %s",
                super.getInfo(), minAge, hypoallergenic);
    }

    /**
     * set info about food
     * 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     * @param minAge минимальный возраст
     * @param hypo   гиполаллергенный
     */
    public void setInfo(String name, int price, int amount, String unit, int minAge, Boolean hypo) {
        super.setInfo(name, price, amount, unit);
        this.minAge = minAge;
        this.hypoallergenic = hypo;
    }
}

class milk extends drink {
    private Double fat;
    private String bestBeforeDate;

    protected String getInfo() {
        return String.format("%s \nЖирность: %.1f \nСрок годности: %s",
                super.getInfo(), fat, bestBeforeDate);
    }

    /**
     * set info about food
     * 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     * @param volume объем
     */
    public void setInfo(String name, int price, int amount, String unit, Double volume, Double fat, String best) {
        super.setInfo(name, price, amount, unit, volume);
        this.fat = fat;
        this.bestBeforeDate = best;
    }
}

class lemonade extends drink {

}

class bread extends food {
    private String typeOfFlour;

    protected String getInfo() {
        return String.format("%s \nТип муки: %s", super.getInfo(), typeOfFlour);
    }

    public void setInfo(String name, int price, int amount, String unit, String best, String type) {
        super.setInfo(name, price, amount, unit, best);
        this.typeOfFlour = type;
    }
}

class egg extends food {
    private int numberOfPieces;

    protected String getInfo() {
        return String.format("%s \nКоличество яиц: %d", super.getInfo(), numberOfPieces);
    }

    public void setInfo(String name, int price, int amount, String unit, String best, int numb) {
        super.setInfo(name, price, amount, unit, best);
        this.numberOfPieces = numb;
    }
}

class mask extends hygieneItems {

}

class toiletePapper extends hygieneItems {
    private int numberOfLayers;

    protected String getInfo() {
        return String.format("%s \nКоличество слоев: %d", super.getInfo(), numberOfLayers);
    }

    /**
     * set info about food
     * 
     * @param name           Название продукта
     * @param price          цена
     * @param amount         количество
     * @param unit           единица измерения
     * @param numberOfPieces количество единиц
     * @param layers         количество слоев
     */
    public void setInfo(String name, int price, int amount, String unit, int numberOfPieces, int layers) {
        super.setInfo(name, price, amount, unit, numberOfPieces);
        this.numberOfLayers = layers;
    }
}

class diapers extends children {
    private String size;
    private Double minWeight;
    private Double maxWeight;
    private String type;
    
    protected String getInfo() {
        return String.format("%s \nРазмер: %s \nМинимальный вес: %.1f \nМаксимальный вес: %.1f \nТип: %s",
                super.getInfo(), size, minWeight, maxWeight, type);
    }

    /**
     * set info about food 
     * @param name   Название продукта
     * @param price  цена
     * @param amount количество
     * @param unit   единица измерения
     * @param minAge минимальный возраст
     * @param hypo   гиполаллергенный
     * @param size  размер
     * @param min минимальный вес
     * @param max максимальный вес
     * @param type тип
     */
    public void setInfo(String name, int price, int amount, String unit, int minAge, Boolean hypo, 
                                                String size, Double min, Double max, String type) {
        super.setInfo(name, price, amount, unit, minAge, hypo);
        this.size = size;
        this.minWeight = min;
        this.maxWeight = max;
        this.type = type;
    }
}

class pacifier extends children {

}

public class product {
    public static void main(String[] args) {
        System.out.println("------------------");

        LocalDate nowDate = LocalDate.now();
        // nowDate.plusDays(2).toString();
        productGeneral prod = new productGeneral();
        prod.setInfo("тестовый продукт", 123, 100, "pcs");
        System.out.println(prod.toString());

        System.out.println("------------------");

        food carrot = new food();
        carrot.setInfo("морковь", 54, 1, "kg", nowDate.plusDays(2).toString());
        System.out.println(carrot.toString());

        System.out.println("------------------");

        drink water = new drink();
        water.setInfo("вода", 290, 1, "pcs", 19.1);
        System.out.println(water.toString());

        System.out.println("------------------");

        hygieneItems toothPaste = new hygieneItems();
        toothPaste.setInfo("зубная паста", 210, 1, "pcs", 1);
        System.out.println(toothPaste.toString());

        System.out.println("------------------");

        children lego = new children();
        lego.setInfo("лего", 2550, 1, "pcs", 3, true);
        System.out.println(lego.toString());

        System.out.println("------------------");

        milk piskarevskiy = new milk();
        piskarevskiy.setInfo("молоко пискаревское", 89, 1, "l", 0.95,
                3.2, nowDate.plusDays(5).toString());
        System.out.println(piskarevskiy.toString());

        System.out.println("------------------");

        lemonade cola = new lemonade();
        cola.setInfo("coca cola", 65, 1, "l", 0.9);
        System.out.println(cola.toString());

        System.out.println("------------------");

        bread borodinskiy = new bread();
        borodinskiy.setInfo("бородинский", 44, 1, "pcs",
                nowDate.plusDays(3).toString(), "ржаная");
        System.out.println(borodinskiy.toString());

        System.out.println("------------------");

        egg eggs = new egg();
        eggs.setInfo("яйца", 100, 1, "pcs",
                nowDate.plusDays(15).toString(), 10);
        System.out.println(eggs.toString());

        System.out.println("------------------");

        mask medicin = new mask();
        medicin.setInfo("медицинские маски", 900, 1, "pcs", 100);
        System.out.println(medicin.toString());

        System.out.println("------------------");

        toiletePapper pushok = new toiletePapper();
        pushok.setInfo("пушок", 210, 1, "pcs", 4, 3);
        System.out.println(pushok.toString());

        System.out.println("------------------");

        diapers haggues = new diapers();
        haggues.setInfo("хаггис", 1400, 1, "pcs", 1, true, "xxs",
                                                         1.2, 4.5, "универсальные");
        System.out.println(haggues.toString());

        System.out.println("------------------");

        pacifier blackDjo = new pacifier();
        blackDjo.setInfo("черный джо", 190, 1, "pcs", 2, true);
        System.out.println(blackDjo.toString());
        
    }
}
