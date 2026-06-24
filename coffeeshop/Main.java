enum CoffeeType {
    ESPRESSO,
    LATTE,
    CAPPUCCINO,
}

class Coffee {

    private final CoffeeType coffeeType;

    private final boolean milk;
    private final boolean sugar;
    private final boolean whippedCream;
    private final boolean extraShot;
    private final boolean chocolateSyrup;

    private Coffee(Builder builder) {
        this.coffeeType = builder.coffeeType;
        this.milk = builder.milk;
        this.sugar = builder.sugar;
        this.whippedCream = builder.whippedCream;
        this.extraShot = builder.extraShot;
        this.chocolateSyrup = builder.chocolateSyrup;
    }

    // Getters

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public boolean hasMilk() {
        return milk;
    }

    public boolean hasSugar() {
        return sugar;
    }

    public boolean hasWhippedCream() {
        return whippedCream;
    }

    public boolean hasExtraShot() {
        return extraShot;
    }

    public boolean hasChocolateSyrup() {
        return chocolateSyrup;
    }

    @Override
    public String toString() {
        return (
            "Coffee{" +
            "coffeeType=" +
            coffeeType +
            ", milk=" +
            milk +
            ", sugar=" +
            sugar +
            ", whippedCream=" +
            whippedCream +
            ", extraShot=" +
            extraShot +
            ", chocolateSyrup=" +
            chocolateSyrup +
            '}'
        );
    }

    public static class Builder {

        private final CoffeeType coffeeType;

        private boolean milk;
        private boolean sugar;
        private boolean whippedCream;
        private boolean extraShot;
        private boolean chocolateSyrup;

        public Builder(CoffeeType coffeeType) {
            if (coffeeType == null) {
                throw new IllegalArgumentException("coffeeType cannot be null");
            }

            this.coffeeType = coffeeType;
        }

        public Builder milk(boolean milk) {
            this.milk = milk;
            return this;
        }

        public Builder sugar(boolean sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder whippedCream(boolean whippedCream) {
            this.whippedCream = whippedCream;
            return this;
        }

        public Builder extraShot(boolean extraShot) {
            this.extraShot = extraShot;
            return this;
        }

        public Builder chocolateSyrup(boolean chocolateSyrup) {
            this.chocolateSyrup = chocolateSyrup;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}

interface PricingStrategy {
    double calculatePrice(double basePrice);
}

class NormalPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}

class PremiumPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }
}

class FestivePricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.8;
    }
}

class WeekendPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.85;
    }
}

class CoffeePricingService {

    private PricingStrategy strategy;

    public CoffeePricingService(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    private double calculateBasePrice(Coffee coffee) {
        double price = 0;
        switch (coffee.getCoffeeType()) {
            case ESPRESSO:
                price += 100;
                break;
            case LATTE:
                price += 150;
                break;
            case CAPPUCCINO:
                price += 180;
                break;
        }

        if (coffee.hasMilk()) {
            price += 20;
        }

        if (coffee.hasExtraShot()) {
            price += 30;
        }

        if (coffee.hasWhippedCream()) {
            price += 25;
        }

        if (coffee.hasChocolateSyrup()) {
            price += 40;
        }

        return price;
    }

    public double calculatePrice(Coffee coffee) {
        double basePrice = calculateBasePrice(coffee);
        return strategy.calculatePrice(basePrice);
    }
}

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee.Builder(CoffeeType.LATTE)
            .milk(true)
            .sugar(true)
            .extraShot(true)
            .chocolateSyrup(true)
            .build();

        System.out.println(coffee);

        CoffeePricingService pricingService = new CoffeePricingService(
            new WeekendPricingStrategy()
        );
        double price = pricingService.calculatePrice(coffee);

        System.out.println("Price = " + price);
    }
}
