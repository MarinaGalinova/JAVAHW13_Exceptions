import static java.awt.SystemColor.text;
import static java.util.regex.Pattern.matches;

public class ProductManager {
    private Repository repo;

    public ProductManager(Repository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy(String text) {

        int searchByText = 0;
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1]; // временный массив в случае совпадения
                for (int i = 0; i < tmp.length; i++) {
                    if (result.length > 0) {
                        tmp[i] = result[i];
                    }
                    result = tmp;
                }
                result[searchByText] = product;
                searchByText++;// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String text) {
//        if (product.getName().contains(text)) {
//            return true;
//        } else {
//            return false;
//        }
        // или в одну строку:
        String s1 = product.getName();
        return product.getName().contains(text);
    }
}


//        умеет добавлять Product в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс,
//        конструктор которого будет принимать параметром репозиторий, а также с методом publiс void add(Product product)
//        и методом поиска (см. ниже).
//        Как осуществлять поиск
//        У менеджера должен быть метод searchBy(String text), который возвращает массив найденных товаров.
//
//        Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать
//        определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт
//        поисковому запросу.
//
//        При проверке на соответствие запросу товара мы проверяем вхождение запроса в текст названия товара.