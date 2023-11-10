<!-- # Code-Blogs -->



## Instructions

Git setup instructions to make contributions to the repository.



## Install Git

Download the latest git. 

https://git-scm.com/download



## Clone this repository

Create a folder to clone the repository.

Open the terminal and run the following git command:
```bash
git clone https://github.com/venkys-io/Code-Blogs.git
```



If this is the first time using git. A browser tab pops up to login into your GitHub account.

and set the default config username and email. This is necessary to make any commits on the repository.

```bash
git config --global user.name "yourUserName"
git config --global user.email "YourEmailId@gmail.com"
```

## Create a branch

Change to the repository directory on your computer (if you are not already there):

```bash
cd Code-Blogs
```

make sure you are in the correct directory.
```bash
C:\Users\....\Code-blogs\>
```

Now create a branch using `git checkout` command:

```
git checkout -b "yourBranchName"
```

you will be switched to your branch.

## Make changes or Add your files

Now write your blogs.

Open vs-code in the repository.

Shortcut:
```bash
  C:\Users\....\Code-blogs\> code .
```


To create a blog for the program `programs-prod/algorithms/Arrays/Easy/Palindrome`

Create a `README.md` file as specified format.

Example:

<pre>
Code-Blogs
  └───Arrays
        ├───Easy
        │   └───Palindrome
        |       └───README.md
        └───Medium

</pre>


Now write the blog in `markdown`.

To know more about markdown. visit

[Cheatsheet1](https://www.freecodecamp.org/news/markdown-cheatsheet/)<br>
[Cheatsheet2](https://www.markdownguide.org/cheat-sheet/)







## Commit those changes.

Even though you have created a file. `Git` actually doesn't track those files.

you can check the status of your branch. using `git status` command.

```bash
git status
```

It displays all the changes you made on the branch.


Add those changes to the branch you just created using the `git add` command:

```bash
git add .
```

Now commit those changes using the git commit command:

```bash
git commit -m "your commit message"
```


## Push changes to GitHub.

push the changes using the command `git push`

```bash
git push -u origin your-branch-name
```

replace your-branch-name with the name of the branch you created earlier.


- Note: You might get Authentication errors if it was your first time.



## Raise a Pull Request for review.

Now open GitHub to see those changes.

Now open `pull request` tab on GitHub repository. 

Hit on Compare & Pull request.

Mention your changes.

Hit on create pull request.
