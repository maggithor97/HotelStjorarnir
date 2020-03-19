# Gervigögn

Þessi mappa inniheldur forrit sem
búa til og hlaða inn gögnum í 
gagnagrunninn, sem og listum af
úttökum úr þessum forritum.

### Listar af hótelum með herbergjum

`gen_hotels.py` prentar út lista af hótel herbergjum,
þar sem gildi eru aðskilin með semí-kommu.
Fyrsta línan í listanum er

```
Name;City;Address
```

og það þarf að senda hana inn sem viðfang

```
python3 gen_hotels.py "Hótel Saga;Reykjavík;Hagatorg"
```

Næstu línur þar á eftir eru herbergin

```
RoomType;RoomNum;Price
```

en þau eru harð-kóðuð í forritið. Það væri
skemmtilegra að taka saman mismundandi 
upplýsingar svo hótelin innihaldi öll ekki
nákvæmlega sama fjölda og gerðir
af herbergjum.

### Listi af dagsetningum

`gen_date.py` prentar út lista af gildum dagsetningum, 
þar sem dagsetningar eru á forminu: 

```
YYYY-MM-DD
```

Hver lína inniheldur tvær dagsetningar,
`checkIn` og `checkOut`, aðskildar með 
semí-kommu:

```
2020-05-04;2020-05-15
```

Dagsetningarnar eiga ekki að spanna
meira en tvær vikur og eru allar innan ársins
2020 fyrir utan örfáar í lok desember og
byrjun janúar.

Forritið tekur eitt viðfang, sem er 
fjöldi paraðra dagsetninga:

```
python3 gen_dates.py 1500
```

### Hvar eru gögnin geymd?

+ `hotels` mappan inniheldur skjöl sem 
  innihalda upplýsingar um hvert hótel,
  þar sem upplýsingarnar eru úttak úr 
  `gen_hotels.py`.

+ `list_of_hotels` inniheldur lista
af skjölunum í `hotels` möppunni.

+ `list_of_dates` inniheldur lista
  af dagsetningum sem er úttak úr
  `gen_dates.py`.

### Hvernig er gögnunum komið í gagnagrunninn?

`Connect.java` notar `list_of_hotels`
til að finna og ná í upplýsingarnar úr
skjölunum fyrir hvert og eitt hótel í 
`hotels` möppunni og hlaða þeim inn í 
gagnagrunninn. 

Ég er ekki búinn að útfæra forrit sem
les inn dagsetningarnar en skal gera 
það fljótlega. 
