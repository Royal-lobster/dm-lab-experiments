# READING DATA SET
data <- read.csv("datasets/labor.csv")

# DELETE UNNECESSARY COLUMNS
data <- data[2:6]

# REPLACE MISSING AGE WITH AVERAGE AGE
data$Age[is.na(data$Age)] <- as.integer(mean(data$Age, na.rm = T))

# REMOVE TUPLES WITH MISSING WORK
data <- data[!data$Work == "", ]

# REPLACE MISSING SALARY WITH MEDIAN
data$Salary[is.na(data$Salary)] <- median(data$Salary, na.rm = T)

# NORMALIZE SALARY and AGE TO [0, 1] using min-max normalization
normalize <- function(x) {
    return((x - min(x)) / (max(x) - min(x)))
}

data$Salary <- normalize(data$Salary)
data$Age <- normalize(data$Age)

# VIEW FINAL DATA
View(data)