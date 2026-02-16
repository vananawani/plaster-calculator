# Plaster Calculator（石膏量計算ツール）

## 概要
石膏クラフト制作時に必要な  
**石膏と水の量を型枠の形状に合わせて自動計算するツール**です。

モールドの形状・サイズ・個数・ロス率を入力すると、  
実制作に即した材料量を算出します。

---

## 解決したい課題
- 手計算が面倒で時間がかかる（「モールドの体積」 ≠「石膏粉＋水の重さ」）  
- 目分量や計算ミスによる材料不足や余りが起きる →すぐ硬化が始まるのでやり直しがききにくい 
- ロス分（攪拌容器や混ぜ棒にくっついて残る分）や中空構造(窪んだ構造)を考慮しにくい  

→ これらを **シンプルな入力だけで解決** します。

---

## 主な機能

### 基本機能
- 円柱・円錐・直方体などの体積計算  
- 石膏1kgあたりに必要な水の量と硬化時体積入力
- ロス率を含めた必要量算出   

### 中空構造への対応
- 外形体積 − 内形体積 による**中空計算**  
- ペン立て・小物入れ・キャンドルホルダー・縁付きトレー等を想定  
- 内側サイズ入力による実制作ベースの材料算出  

---

## 将来予定の高度機能
- 単位切替（mm / cm） 
- 五角形・六角形など多角形形状への対応  
- 星型・ハート型・雲型など複雑形状の近似計算  
- 任意形状モールドへの対応  
- わかりやすいUI（図式化）とキャプション
- 画像やSVGからの**面積自動計算**  
- メーカーと商品名(or バーコード)入力による、水量・硬化時体積の自動入力
- 設定保存・履歴管理  
- スマホ対応（PWA）  
- データベース連携  

---

## 使用技術

### 現在
- Excel（仕様設計・計算ロジック整理）
- HTML / CSS / JavaScript  
- Git / GitHub  

### 今後実装予定
- Python（Flask）  

---

## 使い方

1. モールドの外形を選択  
2. サイズ・個数・ロス率を入力  
3. 必要に応じて中空サイズを入力  
4. 水量・硬化時体積を入力（メーカー表示数値）
5. 必要材料量が自動表示される  

---

## ロードマップ

- [ ] Excel仕様完成  
- [ ] Webアプリ（JavaScript）実装  ←ここまでchatGPTと一緒に3.5h
- [ ] 細かい機能・UIの改善  
- [ ] Flaskによるバックエンド化 
- [ ] 画像から面積計算機能の実装  
- [ ] スマホ最適化（PWA）  

---

## 制作背景
石膏やジェスモナイトでのハンドクラフト制作時、
新しいモールドを使う際に目分量で石膏の量を決めていましたが、
いつも余らせたり足りなかったりするという実体験から、 
 **無駄を減らせる材料計算ツールを作りたい**と考え本プロジェクトを開始しました。

ハンドメイド好きだけど忙しいからいちいち面倒な計算はしたくないママさんや、
なるべく材料に無駄が出ないよう制作をしたい作家さんなどをターゲットに、
実用性と技術学習を両立した  ポートフォリオ作品として開発を進めています。

---

## 作者
- Name: Nana Matsumoto  
- GitHub: to be added




# Plaster Calculator

## Overview
This is a tool that **automatically calculates the amount of plaster and water needed** based on the shape of your mold for plaster craft projects.

By entering the mold's shape, size, quantity, and loss rate,  
it calculates the required materials accurately for actual production.

---

## Problems It Solves
- Manual calculations are tedious and time-consuming ("mold volume" ≠ "weight of plaster powder + water")  
- Misjudging or calculation errors can lead to material shortages or excess → hardening starts immediately, making it hard to redo  
- Difficult to account for loss (plaster sticking to mixing containers or sticks) and hollow structures (recessed shapes)  

→ This tool **solves these issues with simple inputs only**.

---

## Key Features

### Basic Features
- Volume calculation for cylinders, cones, rectangular prisms, etc.  
- Input required water per 1 kg of plaster and hardened volume  
- Calculates total required amount including loss rate  

### Support for Hollow Structures
- **Hollow calculation**: Outer volume − Inner volume  
- Designed for pencil holders, small containers, candle holders, trays with rims, etc.  
- Input inner dimensions to calculate materials for actual production  

---

## Planned Advanced Features
- Unit switching (mm / cm)  
- Support for polygons (pentagons, hexagons, etc.)  
- Approximate calculation for complex shapes (star, heart, cloud)  
- Support for arbitrary-shaped molds  
- User-friendly UI with visual aids and captions  
- **Automatic area calculation** from images or SVG  
- Automatic input of water amount and hardened volume based on manufacturer & product name (or barcode)  
- Save settings and history management  
- Mobile support (PWA)  
- Database integration  

---

## Technologies Used

### Currently
- Excel (spec design & calculation logic)  
- HTML / CSS / JavaScript  
- Git / GitHub  

### Planned
- Python (Flask)  

---

## How to Use

1. Select the mold’s outer shape  
2. Enter size, quantity, and loss rate  
3. Enter inner dimensions if needed (for hollow molds)  
4. Enter water amount and hardened volume (from manufacturer info)  
5. Required materials are displayed automatically  

---

## Roadmap

- [ ] Excel specifications completed  
- [ ] Web app (JavaScript) implementation ← 3.5h with ChatGPT  
- [ ] Fine-tune features & UI  
- [ ] Backend implementation using Flask  
- [ ] Implement area calculation from images  
- [ ] Mobile optimization (PWA)  

---

## Background
When creating handcrafts using plaster or Jesmonite,  
I used to estimate plaster amounts by eye for new molds,  
which often resulted in leftover or insufficient material.  
This inspired me to create a **material calculation tool to reduce waste**.

Target users include busy crafters or parents who don’t want to spend time on tedious calculations,  
and artists who want to minimize material waste.  
This project combines **practical utility** with **technical learning** as a portfolio piece.

---

## Author
- Name: Nana Matsumoto  
- GitHub: to be added