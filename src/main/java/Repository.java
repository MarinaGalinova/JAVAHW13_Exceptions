public class Repository {
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

    public Product findById(int id) {
        for (Product product : getProducts()) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] deleteProductByID(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Нет элемента с таким id:" + id);
        }

        Product[] tmp = new Product[products.length - 1];

        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

            }
        }
        products = tmp;
        return tmp;
    }


}
