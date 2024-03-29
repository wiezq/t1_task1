# API для обзора продуктов
#### Этот API предоставляет конечные точки для управления продуктами, категориями и обзорами.

### Подробную документацию API можно найти в [Swagger](http://localhost:8080/swagger-ui/index.html).

## Enpoints
### Продукты
- GET /api/products/{id}: Получить продукт по ID.
- PUT /api/products/{id}: Обновить продукт по ID.
- DELETE /api/products/{id}: Удалить продукт по ID.
- GET /api/products: Получить все продукты с пагинацией, сортировкой и фильтрацией.
- POST /api/products: Создать новый продукт.
### Категории
- GET /api/categories/{id}: Получить категорию по ID.
- PUT /api/categories/{id}: Обновить категорию по ID.
- DELETE /api/categories/{id}: Удалить категорию по ID.
- GET /api/categories: Получить все категории.
- POST /api/categories: Создать новую категорию.
### Обзоры
- GET /api/reviews/{id}: Получить обзор по ID.
- PUT /api/reviews/{id}: Обновить обзор по ID.
- DELETE /api/reviews/{id}: Удалить обзор по ID.
- POST /api/reviews/products/{productId}: Создать новый обзор для продукта.
- GET /api/reviews: Получить все обзоры.

## Запуск приложения
### С помощью docker-compose
Для запуска приложения с помощью docker-compose выполните следующую команду в корневом каталоге проекта:
```bash
docker-compose up
```


## Модели данных
Подробную информацию о моделях данных можно найти в документации Swagger.

### Использование
API доступен по адресу http://localhost:8080. Вы можете использовать инструменты, такие как Postman или curl, для взаимодействия с конечными точками API.

##### Например, чтобы получить продукт по ID:

GET http://localhost:8080/api/products/1

Чтобы создать новый обзор для продукта:

POST http://localhost:8080/api/reviews/products/1
Content-Type: application/json

```json
{
"rating": 4,
"comment": "Отличный продукт!",
"productId": 1
}
```

### Реализация Criteria API для фильтрации продуктов.
Например, чтобы получить все продукты с ценой от 1000 до 2000 и рейтингом от 4 до 5:

Нужно выполнить запрос:
```http request
GET http://localhost:8080/api/products?page=0&size=10&sort=desc&sortBy=price&maxPrice=500000&categoryId=1
```
Результат
```json
{
    "content": [
        {
            "id": 2,
            "price": 295835,
            "categoryId": 1,
            "averageRating": 2.8,
            "name": "Product 2 in Electronics",
            "description": "This is a product description."
        },
        {
            "id": 5,
            "price": 294944,
            "categoryId": 1,
            "averageRating": 1.4,
            "name": "Product 5 in Electronics",
            "description": "This is a product description."
        },
        {
            "id": 3,
            "price": 110734,
            "categoryId": 1,
            "averageRating": 3.4,
            "name": "Product 3 in Electronics",
            "description": "This is a product description."
        },
        {
            "id": 1,
            "price": 71326,
            "categoryId": 1,
            "averageRating": 2.2,
            "name": "Product 1 in Electronics",
            "description": "This is a product description."
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "unsorted": false,
            "sorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 4,
    "first": true,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "unsorted": false,
        "sorted": true
    },
    "numberOfElements": 4,
    "empty": false
}
```
Все параметры являются необязательными.
#### Список параметров
- minPrice: Минимальная цена продукта.
- maxPrice: Максимальная цена продукта.
- minRating: Минимальный рейтинг продукта.
- maxRating: Максимальный рейтинг продукта.
- page: Номер страницы.
- size: Количество элементов на странице.
- sort: Поле для сортировки. Например, sort=price. Возможные значения: price, avarageRating.
- sortBy: Направление сортировки. Возможные значения: asc, desc.
- categoryId: ID категории продукта.
- description: Поиск по описанию продукта.



Обратитесь к документации Swagger для получения более подробной информации о параметрах и ответах каждой конечной точки. 🚀


# Consumer 
Для демонстрации работы с API был создан простой клиент, который позволяет взаимодействовать с API с помощью RestTemplate.

## Запуск приложения
Приложение запустится автоматически при запуске 
```bash
docker compose up
```

## Использование
Результат вызовов можно увидеть в консоли приложения. Они выводятся с помощью логгера.
