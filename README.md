# template-api-backend-java-maven-spring-mysql
This is a work in progress and may contain bloat. The project is designed to make starting an API project quicker.

# Setting up your new repo's main branch

### Clone the target repo (repo-B)
```bash
git clone git@github.com:<username>/repo-B
```

Then cd into that new clone repo dir.

### Pull the template repo's branch (repo-A)
While in the target repo's dir, run the following:
```bash
git pull git@github.com:<username>/repo-A <branch_name>
```

This will pull in repo-A's branch into repo-B along with repo-A's commit history.

### Delete Git and Initialise Repo
Run the following command to delete the `.git` file:
```bash
rm -rf .git
```
Once that is deleted, run:
```bash
git init;
git remote add origin git@github.com:<username>/<repo-name>
```

### Commit your code
You will need to re-commit your code to your current branch:
```bash
git add -A;
git commit -am "Initial commit"
```

### Push new branch to repo
You may notice your new branch name is `master`. If you wish to change this to something like `main`, then first you will need to run:
```bash
git branch -m main
```
After that, you can now force push this branch to the remote repo:
```bash
git push -f origin main
```

### DOCKER
Build image:
```bash
docker build -t <name_of_image>:latest -f ./ecs-image-build/Dockerfile .
```

# Default settings
You will need to change a few defaults for the project to work correctly.
1. The _**group id**_ for Maven needs to change to something appropriate. This needs changing in both the pom and packages (main and test).
2. The _**artifact id**_ will also need to change in the pom.
3. The _**url for the MySQL connection**_ is currently set to a default local host url.
4. Spring security is disabled by default - this will need to be added to the pom.
5. Dependency versions will not necessarily be up-to-date - ensure this is reviewed when starting a new project by viewing the [Maven Repo](https://mvnrepository.com/).
