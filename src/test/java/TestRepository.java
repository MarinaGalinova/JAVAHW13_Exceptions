import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class TestRepository {

    Product product1 = new Product(1, "Повелитель мух", 500);
    Product product2 = new Product(2, "Мир глазами мух Гарпа", 20);
    Product product3 = new Product(3, "Сердце Пармы", 10_000_000);

    @Test
    public void createRepository() {
        Repository repo = new Repository();
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void delByID() {
        Repository repo = new Repository();
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        repo.deleteProductByID(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextOneword() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        String text = "Повелитель";

        Product[] expected = {product1};
        Product[] actual = manager.searchBy(text);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextOneword2Result() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        String text = "мух";

        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy(text);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextOneword0Result() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        String text = "Оляпка";

        Product[] expected = {};
        Product[] actual = manager.searchBy(text);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByHoleText() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        String text = "Повелитель мух";

        Product[] expected = {product1};
        Product[] actual = manager.searchBy(text);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchById() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product expected = product1;
        Product actual = repo.findById(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteById() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product2, product3};
        Product[] actual = repo.deleteProductByID(1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByDoesentExistingId() {

        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.deleteProductByID(4));
    }
}


