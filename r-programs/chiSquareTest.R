# Correlation is done for ordinal values where
# as for nominal values, its not possible to compute
# so we use tests. The chi-square test of independence
# evaluates whether there is an association between the
# categories of the two variables.

library(MASS)

stu_data <- data.frame(survey$Smoke, survey$Exer)
stu_data <- table(survey$Smoke, survey$Exer)
print(stu_data)

print(chisq.test(stu_data))

# OUTPUT =>
#         Freq None Some
#   Heavy    7    1    3
#   Never   87   18   84
#   Occas   12    3    4
#   Regul    9    1    7
#
#         Pearson's Chi-squared test
# data:  stu_data
# X-squared = 5.4885, df = 6, p-value = 0.4828
#
# SUMMARY =>
#
# So, since  p-value 0.4828 is greater than the .05,
# we conclude that the smoking habit is independent of the
# exercise level of the student and hence there is a weak or
# no correlation between the two variables.