![[Docker-Architecture-excalidraw]]

- if exit from app means that you closed the container .
- image => حاجه لوجيكال وبتكون read only بتشاور على ال base images مثلا و بتوصف ال image .

---
### manifest file 

how docker knows the OS & architecture of system ??

using manifest file :

manifest list :                    

amd/linux
arm64/linux

---

### image layers

ال image بتتكون من مجموعه من ال layers كل layer بيتعملها download لوحدها 
download => extract => pull 

- each layer has its own id .
	- عشان لو جيت احمل image تانيه بس بتستخدم نفس ال layer ف انا هاخدها كوبي مش لسه هحمل .
	
- ال layer عباره عن شوية فايلات مثلا 1 و 2  و  3  

---
### Containers 

- runtime of image 

![[docker-remove.png]]

![[Docker-self-heaking.png]]

---

### copying file to docker

- we want to run script inside container, copy file from host to container and execute it inside of it .
- ![[Docker-Commands#copy file]]



---
### networking with docker :

![[Docker-Architecture 2025-08-25 22.44.24.excalidraw]]

- ال كونتينرز بيكون ليهم ip عشان يعرفوا يكلموا بعض جوا بس لازم يكونوا في نفس النيتورك .
- عشان واحد يعرف يكلم التاني بنجرب ب ال ping او ممكن نستخدم curl وبنحدده ب استخدام ال ip .
	-  في طريقة اسهل عن طريق إننا بنضيف اسم الهوست اللي مربوط ب ال IP
	  و ده بيهسل علينا بدل ما نحفظ ال IP .
	![[Docker-Commands#defining host inside container]]

- تلقائي ال containers بيكونوا في bridge network .
- container can be assigned with more than one network .
  
![[Docker-Commands#defining network type]]

---
### Storage
![[Docker-Architecture 2025-08-26 03.23.02.excalidraw]]

- التعديلات اللي بعملها على الفايلات في الكونتينر هيا عباره عن directory موجود في local host .
#### طب ازاي الداتا تكون موجوده على الجهاز متتمسحش لما امسح الكونتينر ؟؟
#### bind mount 

- يكون عندي فولدر موجود على docker host ويتشاف بشكل دائم من الكونتينرز ولما نغير حاجه تسمع جوا الكونتنر .
- كأن الكونتينر موجود جواه shortcut بيشاور على ال mount اللي موجود على ال host .
![[Docker-Commands#bind mount]]

---
### volumes :

- مساحة تخزين خارج الكونتينر .
- تقدر تشوفها من جوا الكونتينر نفسه ولو الكونتينر اتمسح هيا بتفضل موجوده على ال docker host .
- تقدر تشاركها مع اكتر من container ويكونوا شايفين نفس الداتا .
- عشان لو عاوزين نعمل backup & restore وكمان مش مضطرين نحفظ اماكن الملفات احنا بس بنكتب اسم ال volume 
- التعديل لازم يكون على نفس الباث اللي معمول عليه ال volume .
- two-way sync
- /var/lib/docker/volumes 

---
## Containerizing an application
### Dockerfile :
```
from python => pull python latest

workdir /app => mkdir /app cd app

copy file.txt . 

run pip install -r file.txt

copy hello.py

cmd python hello.py => execute command => happens in runtime of container .
```

- build context => commands run while building image . 
- ('المكان اللي فيه docker file')
- runtime context => command run inside container .

- حطينا ال requirements في ملف لوحدها وعملنا عليها install عشان يكونوا متجمعين في مكان واحد ولو حبيت اعدل اعدل في مكان واحد فقط .

![[Docker-Commands#building image]]

- intermediate container to build layers .
- ممكن اخد الفولدر بتاعي اللي فيه Dockerfile و ارفعه ع جيت هاب عشان لو حد عاوز يعمل image منه 

#### docker file explained :

##### from : 

- used to define base image .
##### workdir : 

- المكان اللي هيتم فيه ال build يتاع ال image ولو الفايل مش موجود هو هيكريته .
##### copy : 

- copy files from build context .
	- لو عندي فايل اسمه فيه مسافات بحطه في "" .

##### add :

- لو عاوز احمل ملف من ع النت او ملف جوا archived بيتفك جوا ال image .

##### shell :

- أل shell اللي عاوز انفذ بيه الاوامر اللي في docker file اثناء ما build image .

##### run :

- اوامر عاوز اشغلها اثناء ما انا ب build image فعلياً كل run بتعمل layer جديده .
- بيشتغل مع standard shell .

label :

- meta data added to image : docker image inspect .
- مبتغيرش في image ولا container


##### env :

- بت configure environment variables .
- global for the entire image and & intermediate containers 

##### Entry point & cmd :
- من ضمن ال meta data بتاعة ال image .
- الحاجات اللي عاوزه تتنفذ اول ما افتح الكونتينر .
- start up apps مثلا زيها .
- بقول لل image لما الكونتينر يتعمله run في interactive mode لو محدش حدد هو عاوز ايه يتفتح انت نفذ الامر ده اول ما ال container يشتغل .
```shell
افتح الباش
entrypoint ["/bin/bash","-c"]
	نفذ الامر ده جنبه
CMD "< >"

زي

/bin/bash -c python3
```

---
### Docker ingore :

#### .dockerignore file :

- used to put files you want to ignore in the build of image .
```shell
*.py !aa.py
```

---

## Docker Compose :

![[docker-compose]]

service = container (code) + network + storage .