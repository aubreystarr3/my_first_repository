mean(MHEALTH$HT)
sd(MHEALTH$HT)
mean(FHEALTH$HT)
sd(FHEALTH$HT)
hist(MHEALTH$HT,main="Men's Heights",col="purple")
hist(FHEALTH$HT,main="Women's Heights",col="yellow")
summary(MHEALTH$HT)
lower <- 66.30 - 1.5*IQR(MHEALTH$HT) 
upper <- 70.08 + 1.5*IQR(MHEALTH$HT)
sum(MHEALTH$HT < lower)
(MHEALTH$HT > upper)
lower
boxplot(MHEALTH$BMI, FHEALTH$BMI,main="Comparison of BMIs in Men and Women",col=c("purple", "pink"),names=c("Men","Women"), ylab="BMI (in kg/m^2)")
summary(MHEALTH$BMI)
summary(FHEALTH$BMI)

stripchart(MHEALTH$WT,method="stack",pch=8,main="Dot Plot of Men's Weight",col="orange",xlim=c(94,256),xlab="Weights (in lbs)")

stripchart(FHEALTH$WT,method="stack",pch=6,main="Dot Plot of Women's Weight",col="dark blue",xlim=c(94,256),xlab="Weights (in lbs)")
cor(MHEALTH$BMI,MHEALTH$WAIST)
plot(MHEALTH$BMI,MHEALTH$WRIST,main="Scatterplot of Men's BMIs vs. Waist Sizes",xlab="Bmis (in kg/m^2)",ylab="Waist Circumfrence (in cm)",pch=17,col="dark red")

dose <- c(20,30,40,45,60)
drugA <- c(16,20,27,40,60)
drugB <- c(15,18,25,31,40)
plot(dose,drugA,type="b",pch=17,lty=2)
plot(dose,drugA,type="b",lty="dotted",lwd=3,pch=23,cex=1.5,col="darkgoldenrod1",bg="cornflowerblue",col.axis="deeppink3",fg="gray60",ann=FALSE)
title(main="Response of Test Subjects to Drugs",col.main="lightslateblue",xlab="Dosagte",ylab="Response",col.lab="dodgerblue")
n <- 10
mycolors <- rainbow(n)
n <- 10
mygrays <- gray(0:n/n)
pie(rep(1,n),labels=mycolors,col=mycolors)
pie(rep(1,n),labels=mygrays,col=mygrays)
rainbow_8 <- rainbow(8)
dogs <- c("Ruff\n(3%)","Snoopy\n(7%)","Odie\n(8%)","Brian\n(11%)","Fluffy\n(14%)","Fido\n(16%)","Barky\n(19%)","Spot\n(22%)")
votes <- c(3,7,8,11,14,16,19,22)
sum(votes)
pie(votes,main="Votes for Best Dog in MTV Poll",labels = dogs,col=rainbow_8)










library(ggplot2)
?ggplot

