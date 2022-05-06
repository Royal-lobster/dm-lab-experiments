# READING DATA SET
data <- read.csv("datasets/labor.csv")

# DELETE UNNECESSARY COLUMNS
data <- subset(data, select = -c(height))

# REPLACE MISSING AGE WITH AVERAGE AGE
data$Age[is.na(data$Age)] <- as.integer(mean(data$Age, na.rm = T))

# REMOVE TUPLES WITH MISSING WORK
data <- data[!data$Work == "", ]

# REPLACE MISSING SALARY WITH MEDIAN
data$Salary[is.na(data$Salary)] <- median(data$Salary, na.rm = T)

# VIEW FINAL DATA
View(data)