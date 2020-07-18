[TOC]

## Git Commit 提交

```
git commit -m "update ***"
```

## Git Branch 建分支

```
## 创建分支
git branch bugFix
## 检出分支
git checkout bugFix

## 创建并检出分支
git checkout -b bugFix
```

## Git Merge 合并分支

```
git checkout -b bugFix
git commit -m "add comment on bugFix"
git checkout master
git commit -m "add comment on master"
git merge bugFix
```

## git rebase 合并分支

```
git checkout -b bugFix
git commit -m "add comment on bugFix"
git checkout master
git commit -m "add comment on master"
git checkout bugFix
git rebase master
```

## 分离HEAD

```
git checkout bugFix
```
## 相对引用

```
git checkout bugFix^

git branch -f bugFix HEAD~3
```


## 撤销变更

```
$ git reset HEAD~1

$ git checkout pushed

$ git revert HEAD
```
## 自由修改提交树

1: Git Cherry-pick

```
 Git Cherry-pick c3 c4 c7
 
```

2:交互式 rebase

```
git rebase -i overHere --solution-ordering C3,C5,C4
```





