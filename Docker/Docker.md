
## Why Docker?

قبل Docker كان في مشاكل أساسية:

1. **Installation Errors**
    
    - كل مطور بيحتاج يثبت البرامج (dependencies) يدويًا.
        
    - ساعات بتظهر مشاكل أثناء التثبيت (مكتبات ناقصة – بيئة مش متوافقة).
        
2. **Version Conflicts**
    
    - مثال: مشروع محتاج Python 3.7، وآخر محتاج Python 3.10 → يحصل تضارب.
        
    - نفس الشيء ينطبق على Java، Node.js، أو المكتبات.
        
3. **Time Wasted**
    
    - تكرار التثبيت وضبط الإعدادات لكل مشروع أو كل مطور جديد.
        
    - يؤدي لضياع وقت كبير بدل ما يركز المطور على الكود.
        
4. **OS & Environment Issues**
    
    - بعض البرامج بتحتاج مواصفات معينة أو نظام تشغيل مختلف.
        
    - بيخلي مشاركة المشروع أو تشغيله على جهاز جديد صعب.
        

---

### الحل → Docker

- **Docker = Software Tool** لحل هذه المشاكل.
    
- بيعتمد على مفهومين أساسيين:
    
    - **Images** → نسخة جاهزة من البرنامج + بيئته + مكتباته.
        
    - **Containers** → نسخة شغالة من الـ Image (زي runtime).
        
- النتيجة:
    
    - سهولة تشغيل التطبيقات بدون صداع التثبيت.
        
    - Consistency (التطبيق يشتغل بنفس الشكل عندك، عند زميلك، أو على السيرفر).
        
    - سرعة في الإعداد (setup time) → من ساعات لدقايق.
        

---

## Docker File 

- هو حاجه بستخدمها عشان اوضح ل دوكر ازاي يشغل البرنامج بتاعي ايه ال dependencies اللي محتاجها عشان يشتغل ازاي هيعمله build و ازاي هيعمله run .


```Dockerfile
from node:14 => 'docker pull node'

  

workdir /app  => create new direcrtory

  

copy package.json . => copy packge to /app

  

RUN npm install => install package

  

copy . . => copy all files to /app

  

EXPOSE 4000 => for documentation

  

cmd ["npm", "start"] => excutable command
```

### CMD

- build docker file  create image from dockerfile
```terminal
docker build -t name .
```

- create container
```shell
docker run --name name-container name-image
```

- لو خرجت من هنا بالطريقه التقليديه ال container هيقفل معايا
	- ممكن اشغله بقا من غير ما ادخل في التيرمنال بتاع الكونتينر باستخدام -d اللي هيا detach
	```shell
	docker run --name my-express-app-container -d my-express-app
	```

- لو عاوز اعرض كل الكونتينرز اللي شغاله 
```shell
docker ps
```

- لو عاوز ادخل interactive terminal

```bash
docker exec -it 9bfd sh
```



## port

كل container بيكون له port خاص بيه جوا دوكر لانه يعتبر بروسيس برضو ف احنا هنعمله port forward

```shell
docker run --name name-container -d -p 80:4000 name-image
```


----

![[Docker-excali]]

---
## Docker Image 

- docker image consists of multiple layers & the container it self doesn't require an OS it is uses the kernel of the device only and after that you can specify the extra OS dependencies you want .
### Docker hub

free open source web application contains all base-images .

### Docker image 

a template 'class - blue print' of your project used to create multiple instances 'containers' of the application with it's dependencies .

- عباره عن layers فوق بعض 

### docker container 

the executable service 'instance' of the image .

----


## optimizing docker 

### do I need to copy all files ?

- اكيد لا يعني مثلا الملف بتاع Dockerfile اكيد مش هكون محتاجه في الكونتينر بتاعي انا بستخدمه بس عشان ا build image ف ب التالي انا مش عاوزه يكون موجود جوا ال image ويستهلك مساحه و ده بيخلينا نيجي ل 

#### .dockerignore

عباره عن ملف بحط فيه الحاجات اللي مش عاوز يتعملها كوبي وانا بعمل ال image بتاعتي 


### do I need to Separate copy ?

- ليه فصلت الكوبي بتاع package عن الكوبي بتاع الملفات ؟ 
	- عشان ال package بيتعملها install وبتكون في cache لكن لو نقلتها مع الباقي اللي هو السورس كود اللي بيتعدل عليه كتير ف كده الكدج في كل مره هيتعملها install وهتاخد مني وقت 

---


## 🐳 Docker Image & Container Concepts

### 1️⃣ Docker Image

- **Structure:** بيتكون من **multiple layers**.
    
    - كل instruction في الـ `Dockerfile` (زي `FROM`, `RUN`, `COPY`) = بيعمل layer جديدة.
        
    - layers دي **read-only**.
        
- **Benefit:**
    
    - لو عندك Images كتير مبنية على نفس الـ Base Image → بيشاركوا نفس الـ layers (توفير مساحة وسرعة).
        

---

### 2️⃣ Docker Container

- هو **Runtime instance** للـ Image.
    
- بياخد layers بتاعت الـ Image + يضيف فوقها **writable layer** (عشان أي تعديل يحصل).
    
- ملوش Kernel خاص بيه → بيستخدم **Kernel بتاع الـ Host OS**.
    

---

### 3️⃣ OS Dependencies

- Container مش محتاج **OS كامل** (زي Virtual Machine).
    
- أنت بتحدد في الـ Image إيه الـ **dependencies/packages** اللي عايزها (مثلاً: `apt-get install curl`).
    
- يعني ممكن يكون عندك Container صغير جدًا مبني على `alpine` (5MB)، أو كبير مبني على `ubuntu` (مئات الـ MBs).
    

---

## 🔑 الخلاصة في سطرين:

- **Image = مجموعة Layers (read-only).**
    
- **Container = نسخة شغالة من الـ Image + writable layer، وتشارك Kernel الـ Host.**
    
- مش محتاج OS كامل، بس تقدر تضيف الـ dependencies اللي انت عايزها.
    

---

بالظبط 👌، Docker **لازم يخزن الـ Layer مرة واحدة على جهازك**، لكن الفكرة:

- لو عندك 10 Images كلهم مبنيين على نفس الـ Base Image (مثلاً `node:18-alpine`):
    
    - الـ Layer بتاعت `node:18-alpine` هتتاخد **مرّة واحدة بس** على جهازك (مثلاً 5MB).
        
    - مش 5MB × 10 = 50MB.
        
- كل Image منهم بيضيف بس الـ Layers الخاصة بيه (الكود + الـ dependencies اللي إنت ضايفها).
    

---

## 🧩 مثال بالأرقام:

- **Base Image (node:18-alpine)** = 5MB.
    
- **Project A Layers** = 20MB.
    
- **Project B Layers** = 15MB.
    

### لو Docker مبيشاركش:

- Project A = 25MB.
    
- Project B = 20MB.
    
- Total = 45MB.
    

### مع Docker (sharing layers):

- Base Image = 5MB (مرة واحدة).
    
- Project A extra layers = 20MB.
    
- Project B extra layers = 15MB.
    
- **Total = 40MB.**
    

---

## 🔑 الخلاصة:

- أيوة الـ Base Image بتتاخد مساحة، بس **مرّة واحدة** فقط مهما كان عندك Images مبنية عليها.
    
- أي Image جديدة بتستخدم نفس الـ Base Image → بتشاور على نفس الـ Layer بدل ما تعمل نسخة جديدة.
    

---

## Volumes :

### bind mount
- ممكن احط الفايلات اللي عاوز اعملها bind في فولدر لوحدها و mount الفولدر ده مع الكونتينر .
- متنساش تعمل build image after changes happen .

---
## Docker compose :

- separate utility comes with docker helps in managing containers .