# Import dataset
train_data <- read.csv("datasets/loan-train.csv")

# Pre process train data
train_data <- subset(train_data, select = -c(Loan_ID))
train_data[train_data == ""] <- NA
na.omit(train_data)

# replace values of Loan_Status with 0 and 1 in place of Y and N
train_data$Loan_Status <-
    ifelse(train_data$Loan_Status == "Y", 1, 0)

# Train model
model <- glm(train_data$Loan_Status ~ .,
    family = binomial,
    data = train_data,
)
print(summary(model))

# Import test data
test_data <- read.csv("datasets/loan-test.csv")

# Pre process test data
test_data[test_data == ""] <- NA
na.omit(test_data)

# Predict Loan_Status
results <- predict(model, newdata = test_data, type = "response")
results <- ifelse(results >= 0.5, "Y", "N")
predicted_data <- data.frame(Loan_ID = test_data$Loan_ID, Loan_Status = results)

View(predicted_data)