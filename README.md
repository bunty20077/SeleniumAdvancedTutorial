
# Selenium Advanced Tutorial




## Authors

- [Sayantan Tarafdar](https://github.com/bunty20077)


## Documentation

Selenium Advanced Tutorial has been created based on Page Object Model.
Framework has been created based on

- [Java](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
- [Gradle](https://github.com/matiassingers/awesome-readme)
- [TestNG](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

 



## Run 

To run this project use below command

def groups = System.getProperty('groups') 

```bash
  ./gradlew clean test -Pbrowser=chrome -Dgroups=SanityTest
```


def groups = project.findProperty('groups')

```bash
  ./gradlew clean test -Pbrowser=chrome -Pgroups=SanityTest
```