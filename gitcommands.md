# Git skipanir

1. git clone
2. git add
3. git commit
4. git push
5. git pull
6. git rm
7. git status

### 1. git clone

Ef þú vilt hafa git repository á tölvunni
þinn, þá notar þú þessa skipun. Hún afritar
git repository og býr til local copy á vélinni
þinni. Það er nóg að hafa `<url>` á það 
repsitory sem þú vilt afrita.

```
git clone <url>
``` 

Núna ætti að vera afrit á svæðinu þar sem
þú framkvæmdir skipunina. 

### 2. git add

Ef þú býrð til nýtt skjal og vilt bæta
því við repository, þá notar þú þessa
skipun. 

Best er að nota relative slóðina
á skjalið. T.d. ef þú ert inni í git 
repository og vilt bæta við nýja skjalinu
`file`:

```
git add file
```

Það er líka hægt að nota rofan `-A`, 
sem bætir öllum breytingum við repository,
en ég mæli gegn því að nota hann, nema
**þú sért 100% viss** að allir aðrir
í teyminu sé ekki með neinar óvistaðar
breytingar hjá sér. Ef notað í kæruleysi
getur það endað í pirrandi git conflict.

### 3. git commit

Ef þú hefur lokið við að keyra `git add`
skipunina, þá viltu eflaust keyra þessa
skipun í kjölfarið. Eins og í `git add`
er best að nota slóðina á viðeigandi
skjal eða möppu. Þú getur líka látið
fylgja skilaboð með `-m` rofanum:

```
git commit -m "Bjó til amazing skjal" file 
```

Ath. að þú verður að keyra `git add` fyrir
`git commit`, annars hefur hún engin áhrif. 
Tilgangur `git commit` skýrist í næsta lið,
`git push`. 

### 4. git push

Núna hafa orðið breytingar í git repository
hjá þér og þú vilt hlaða þeim upp á GitHub.
Til að skjalið `file` verði með í næstu uppfærslu
þarft þú að hafa framkvæmt `git add` **og** 
`git commit`. 

```
git push origin master
```

Núna eru allar breytingar sem þú hefur gert
og lagt fram með `git commit` komnar inn á 
GitHub, sem og skilboðin sem þú skrifaðir
með `-m` rofanum.

### 5. git pull

Ef þú vilt ná í nýjustu útgáfu af git repository,
þá notar þú þess skipun. 

```
git pull origin master
```

Stundum koma upp villuskilaboð þegar maður
keyrir `git push` ef það hafa orðið breytingar
á git repository, sem þú hefur ekki á þinni vél. 
Þá er nóg að keyra þessa skipun og prófa aftur. 

### 6. git rm

Þessi er hættulega, en stundum nytsamlega.
Ef þú vilt eyða `file`, þá er ekki bara
nóg að eyða henni af tölvunni þinni, þú
þarft að eyða henni úr git repository líka.

```
git rm --cached file
```

### 7. git status

Sýnir þér hvaða skjöl eða möppur hafa orðið
fyrir breytingum, sem og skjöl eða möppur
sem eru nýjar og á eftir að bæta við í
git repository, með `git add`.

Skjöl og möppur sem á eftir að bæta við eru
sýndar með rauðum stöfum, en þær sem búið
er að bæta með grænum. Þegar þú keyrir
`git commit` á skjal eða möppu, þá birtist
hún ekki lengur í `git status` 


