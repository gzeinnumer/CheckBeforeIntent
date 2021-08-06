<center>
<img src="https://github.com/gzeinnumer/CheckBeforeIntent/blob/master/preview/example1.gif" width="300"/>
</center>

<h1 align="center">
    Check Before Intent - Check Form Before Leave Activity
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-0.0.1-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Check Form Before Leave Activity</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:CheckBeforeIntent:version'
}
```

---
# Feature List
- [x] [Check Form Before Leave Activity](#check-form-before-leave-activity)

---
# Usage

### Check Form Before Leave Activity

Use `.addView(editText)` to add view that you want to check
* Single View
```java
new CheckBeforeIntent()
    .addView(editText1)
    .isSaveToLeave(...).build();
```

Example
```java
EditText editText1 = findViewById(R.id.ed1);
EditText editText2 = findViewById(R.id.ed2);
Button btn = findViewById(R.id.btn);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        new CheckBeforeIntent()
                .addView(editText1)
                .addView(editText2)
                .isSaveToLeave(new CheckBeforeIntent.CheckBeforeIntentCallBack() {
                    @Override
                    public void isSaveToLeave(boolean isSave) {
                        if (isSave) //true -> free to lease
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        else //false -> not free to leave
                            Toast.makeText(MainActivity.this, "Are you sure leave the activity", Toast.LENGTH_SHORT).show();
                    }
                }).build();

    }
});
```

* Multiple View
```java
new CheckBeforeIntent()
    .addView(editText1)
    .addView(editText2)
    .isSaveToLeave(...).build();
```
```java
List<View> views = new ArrayList<>();
...
new CheckBeforeIntent()
    .addView(views)
    .isSaveToLeave(...).build();
```
```java
View[] views = new View[size];
...
new CheckBeforeIntent()
    .addView(views)
    .isSaveToLeave(...).build();
```

**FullCode**
[**MainActivity**](https://github.com/gzeinnumer/CheckBeforeIntent/blob/master/app/src/main/java/com/gzeinnumer/checkbeforeintent/MainActivity.java)

---
# Example Code/app

[Sample Code And App](https://github.com/gzeinnumer/CheckBeforeIntentExample)

---
# Version
- **1.0.0**
  - First Release

---
# Contribution
You can sent your constibution to `branch` `open-pull`.

---

```
Copyright 2021 M. Fadli Zein
```
