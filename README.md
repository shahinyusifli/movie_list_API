# movie_list_API
A web API that lists and gives options to users to add and modify movies and their details. This part of the application consists of backend code that offers CRUD operation with Spring Boot framework and MongoDB Atlas.


## Functional requriments

#### Movies
1.	Movie can be created with empty reviews.
   - If the creator has not provided an IMDb ID, it should be substituted with a generated ID. The generated ID should begin with one or more letters, which are derived from the genres associated with the created movie. Each letter signifying a genre should be the first letter of that particular genre. The numeric portion of the ID should consist of five unique digits, generated specifically for this purpose.
   - In the event that no genres have been assigned to the movie, the alphabetic portion of the ID should include the letter "oth"
2.	Movie can be deleted or hidden from users if they do not have reviews.
3.	Movie can be seen with title, the last updated date and number of total reviews inside it.
4.	Movies can be seen with titles, one example photos, genres, and release dates.
- If there are not any users reviews, it should return “We do not have any current review”

#### Review
1.	Reviews can be created with user input
- Reviews should not be null. (Validation, global exception handling)	
- Content of reviews should be bigger than 5 and should be less than 50 (Validation, global exception handling)
- Review should not start with “Bad” and “Teriable” words (stream API)
- Reviews can be deleted






## API Reference

### Movie
#### Get all movies

```http
  GET /movie/get
```

#### Get details of movie

```http
  GET /movie/detail/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of movie to fetch |

#### Change flags of movie

```http
  PUT /movie/delete/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id for find for chainging flag of movie |

#### Create new movie

```http
  POST /movie/create
```
### Review
#### Create new review
```http
  POST /movie/id/create/review
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id for find movie of new reviews |

