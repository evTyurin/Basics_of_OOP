package epam.learning.ex2;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    private Map <Product, Integer> shoppingCart;

    public Payment () {
        shoppingCart = new HashMap<>();
    }

    public void setShoppingCart(Map<Product, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void print () {
        for (Product product : shoppingCart.keySet()) {
            System.out.println("name = " + product.getName() + System.lineSeparator() +
                    "price = " + product.price * shoppingCart.get(product) + System.lineSeparator() +
                    "amount = " + shoppingCart.get(product) + System.lineSeparator() +
                    "description: " + System.lineSeparator() + product.description + System.lineSeparator());
        }
    }


    public class Product {
        private int price;
        private String name;
        private String description;

        public Product (String name, int price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        private boolean isContainsKey(Product newProduct) {
            for (Product product : shoppingCart.keySet()) {
                if (product.equals(newProduct)) {
                    return true;
                };
            }
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Product product = (Product) obj;

            return price == product.price && (name == product.name
                    || ( name != null && name.equals(product.getName()))) && (description == product.description
                    || ( description != null && description.equals(product.getDescription())));

        }

        @Override
        public int hashCode() {
            int result = 23;
            result = 7 * price * result;
            result = 11 * name.hashCode() * result;
            result = 13 * description.hashCode() * result;
            return result;
        }

        public void add () {
            if (!shoppingCart.isEmpty()) {
                if (isContainsKey(this)) {
                    shoppingCart.put(this, shoppingCart.get(this) + 1);
                } else {
                    shoppingCart.put(this, 1);
                }
            } else {
                shoppingCart.put(this, 1);
            }

        }

        public void remove () {
            if (!shoppingCart.isEmpty()) {
                if (shoppingCart.get(this) > 1) {
                    shoppingCart.put(this, shoppingCart.get(this) - 1);
                } else {
                    shoppingCart.remove(this);
                }
            }
        }

    }
}


