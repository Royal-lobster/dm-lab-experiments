iris$size <- ifelse(
    iris$Sepal.Length < median(iris$Sepal.Length),
    "small", "big"
)

data <- table(iris$Species, iris$size)
print(data)

result <- chisq.test(table(iris$Species, iris$size))
print(result)