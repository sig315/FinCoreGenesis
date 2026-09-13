# FinCoreGenesis


## 使用技術

### バックエンド
- Java 21
- Spring Boot
- Spring Data JPA

### フロントエンド
- HTML
- CSS
- Thymeleaf

### データベース
- MySQL

### データベース管理ツール
- MySQL Workbench

### ビルドツール
- Maven

### 開発環境
- IntelliJ IDEA
- Git
- GitHub

## システム機能

### 実装済み

- ユーザー登録画面
- ユーザー登録機能
- MySQL接続

### 実装予定

- ログイン
- ログアウト
- 口座登録
- 口座一覧
- 口座詳細
- 口座編集
- 口座削除
- 入金
- 出金

## プロジェクト構成

```text
FinCoreGenesis
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.yml
│   └── test
├── .gitignore 
├── pom.xml
├── README.md
└── .gitignore
```

### ディレクトリ概要

|ディレクトリ|内容|
|---|---|
|src/main/java|Javaソースコード（Controller、Service、Repository、Entityなど）|
|src/main/resources/templates|Thymeleafテンプレート（HTML）|
|src/main/resources/static|CSS・JavaScript・画像などの静的ファイル|
|src/test|テストコード|
|pom.xml|Maven依存関係・ビルド設定|
|README.md|プロジェクト概要|

## 起動方法

### 前提環境

- Java 21
- Maven
- MySQL
- IntelliJ IDEA

### セットアップ手順

1. 本リポジトリをクローンする

```bash
git clone https://github.com/＜あなたのGitHubユーザー名＞/FinCoreGenesis.git
```

2. MySQLでデータベースを作成する

```sql
CREATE DATABASE fincoregenesis;
```

3. `src/main/resources/application.yml` を環境に合わせて設定する

例

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/fincoregenesis
    username: root
    password: ＜MySQLのパスワード＞
```

4. IntelliJ IDEAでプロジェクトを開く

5. `FinCoreGenesisApplication` を実行する

6. ブラウザで以下にアクセスする

http://localhost:8080


## 注意事項

セキュリティ保護のため、`application.yml` のデータベースパスワードはダミー値に変更しています。

実行する際は、ご自身の環境に合わせて設定してください。
