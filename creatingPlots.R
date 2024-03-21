library(ggplot2)
library(gridExtra)
library(grid)
h2 <- read.csv("~/AlgoNumeryczne/Zadanie1/Grafy/h2.csv", header = FALSE, sep = ";")
h2_n <- h2$V1
h2_x <- h2$V2
h2_y <- h2$V3

h2_data <- data.frame(N = h2_n, X = h2_x, Y = h2_y)



h2_table <- tableGrob(h2_data, rows = NULL)

# Save the table as a PNG file
png("~/AlgoNumeryczne/Zadanie1/Grafy/h2_table.png", width = ncol(h2_data)*150, height = nrow(h2_data)*25, units = "px")
grid.draw(h2_table)
dev.off()

png("~/AlgoNumeryczne/Zadanie1/Grafy/h2X_plot.png", width = 1200, height = 900) # Adjust width and height as needed
plot(h2_n, h2_x, type = "l", col = "blue")
abline(h = 0, col = "red")
dev.off()
png("~/AlgoNumeryczne/Zadanie1/Grafy/h2Y_plot.png", width = 1200, height = 900) # Adjust width and height as needed
plot(h2_n, h2_y, type = "l", col = "blue")
abline(h = 0, col = "red")
       
dev.off()


h3 <- read.csv("~/AlgoNumeryczne/Zadanie1/Grafy/h3.csv", header = FALSE, sep = ";")
h3_n <- h3$V1
h3_x <- h3$V2
h3_y <- h3$V3

h3_data <- data.frame(N = h3_n, X = h3_x, Y = h3_y)



h3_table <- tableGrob(h3_data, rows = NULL)

# Save the table as a PNG file
png("~/AlgoNumeryczne/Zadanie1/Grafy/h3_table.png", width = ncol(h3_data)*150, height = nrow(h3_data)*25, units = "px")
grid.draw(h3_table)
dev.off()

png("~/AlgoNumeryczne/Zadanie1/Grafy/h3X_plot.png", width = 1200, height = 900) # Adjust width and height as needed
plot(h3_n, h3_x, type = "p", col = "black")
abline(h = 0, col = "blue")
     
dev.off()
png("~/AlgoNumeryczne/Zadanie1/Grafy/h3Y_plot.png", width = 1200, height = 900) # Adjust width and height as needed
plot(h3_n, h3_y, type = "p", col = "black")

abline(h = 0, col = "blue")
dev.off()

# Read the CSV file
obwod <- read.csv("~/AlgoNumeryczne/Zadanie1/Grafy/obwod.csv", header = FALSE, sep = ";")

# Extract data from the CSV columns
obwod_n <- obwod$V1
obwod_x <- obwod$V2
difference <-abs((2 * pi ) - obwod_x)


# Save the plot to a PNG file
png("~/AlgoNumeryczne/Zadanie1/Grafy/obwod_plot.png", width = 800, height = 500) # Adjust width and height as needed
plot(obwod_n, log(difference), type = "l", col = "blue", 
     xlab = "n", ylab = "log(2π - Value)", main = "Obwod", log = "y") # Set log = "y" for logarithmic y-axis

abline(h = 0, col = "red")
dev.off()



monte <- read.csv("~/AlgoNumeryczne/Zadanie1/Grafy/Monte.csv", header = FALSE, sep = ";")

# Extract data from the CSV columns
monte_n <- monte$V1
monte_x <- monte$V2
difference_monte <- pi - monte_x



png("~/AlgoNumeryczne/Zadanie1/Grafy/monte_plot.png", width = 1600, height = 1200) # Adjust width and height as needed
plot(log(monte_n), difference_monte, type = "l", col = "brown", 
     xlab = "n", ylab = "π - Value", main = "Monte",
     ylim = c(-0.5, 0.5))
abline(h = 0, col = "red")
dev.off()




