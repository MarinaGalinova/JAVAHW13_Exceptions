public class Repository {
    //позволяющий сохранять Product, получать все сохранённые Product и удалять по ID.
    // Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).

    public Product[] products = new Product[0];

    public void saveProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public Product[] getProducts() {
        return products;
    }

    public void deleteProductByID(int id) {
        Product[] tmp = new Product[products.length - 1];

        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

            }
        }
        products = tmp;


    }


}
