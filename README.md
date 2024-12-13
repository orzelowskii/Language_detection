# README: Wykrywanie języka za pomocą sieci neuronowej

## Opis projektu
Projekt implementuje system do wykrywania języka na podstawie analizy tekstu, wykorzystując sieć neuronową opartą na perceptronach. System obsługuje języki polski (PL), angielski (EN) i hiszpański (ES). Analizuje rozkład częstości liter w tekście wejściowym i przewiduje język na podstawie wytrenowanych perceptronów.

## Funkcje
- Klasyfikacja języka: Rozpoznawanie języka na podstawie tekstu lub pliku wejściowego.
- Trenowanie sieci: Możliwość trenowania sieci neuronowej na danych tekstowych z oznaczeniami języka.
- Interaktywny interfejs użytkownika: Obsługa wprowadzania danych i klasyfikacji za pomocą konsoli.

## Jak to działa
1. Faza trenowania:
- Program odczytuje pliki tekstowe z oznaczeniami języków z określonego folderu.
- Dla każdego pliku obliczany jest rozkład częstości liter (a-z).
- Perceptrony dostosowują swoje wagi i progi, aby poprawnie klasyfikować tekst.

2. Faza klasyfikacji:
- Na podstawie dostarczonego tekstu lub pliku system oblicza częstości liter.
- Wynik perceptronów wskazuje najbardziej prawdopodobny język.

3. Interaktywny interfejs:
- Użytkownik może wprowadzać pliki lub teksty do klasyfikacji.
- Program działa w pętli, aż użytkownik wybierze zakończenie pracy.
