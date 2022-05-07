# READING DATA SET
data <- read.csv("datasets/students.csv")

# DELETE UNNECESSARY COLUMNS
data <- subset(data, select = -c(id))

# CREATE NEW COLUMN AND CALCULATE BMI
data$BMI <- data$weight / (data$height / 100)^2

# REMOVE HEIGHT from data
data <- subset(data, select = -c(height))

# NORMALIZE Height and Weight to [0, 1] using min-max normalization
normalize <- function(x) {
    return((x - min(x)) / (max(x) - min(x)))
}
data$weight <- normalize(data$weight)

# perform data discretization on age with
# below 20 as teen,
# 20-30 as young,
# 30-50 as middle,
# 50-70 as senior

data$age <-
    ifelse(data$age < 20, "teen",
        ifelse(data$age < 30, "young",
            ifelse(data$age < 50, "middle", "senior")
        )
    )

# VIEW FINAL DATA
View(data)
