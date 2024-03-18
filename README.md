# RPA for agricultural machinery websites
This project is an RPA developed in Java to collect information from three similar web pages advertising agricultural machinery.

### Supported Websites

The application supports the following websites:

- [Agrofy](https://www.agrofy.com.br)
- [Tratores e Colheitadeiras](https://www.tratoresecolheitadeiras.com.br)
- [Mercado Máquinas](https://www.mercadomaquinas.com.br)

## How to Use

### Cloning the Repository

*Note: Alternatively, you can download the JAR file directly from [here](https://github.com/erick-kleim/rpa-oyster/blob/main/website-analyzer.jar) by clicking on the icon "..." (More file actions) and then selecting "Download", eliminating the need to download the entire repository.*

To clone this repository and get the source code, run the following command in your terminal:

```bash
git clone git@github.com:erick-kleim/rpa-oyster.git
```

### Executing the JAR

You can run the application by executing the provided JAR file. Follow these steps:

1. Open your terminal or command prompt.
2. Navigate to the root folder of the cloned repository.
3. Locate the `website-analyzer.jar` file.
4. Depending on your preferred method:

    #### Option 1: Passing URLs as Arguments
    If you want to provide URLs as command-line arguments, run the following command:
    ```bash
    java -jar rpa-web-crawler.jar https://example.com/machine/123 https://example2.com/machine/mod-987
    ```
    Replace `[https://example.com](https://example.com/machine/123)` and `[https://example2.com](https://example2.com/machine/mod-987)` with the desired URLs.


    #### Option 2: Using Hard Coded Links
    If you prefer to use the hard coded links provided in the code, run the following command:
    ```bash
    java -jar website-analyzer.jar
    ```
    hard coded URLs:
    - [https://www.mercadomaquinas.com.br/anuncio/214554-pa-carregadeira-caterpillar-950h-2012-curitiba-pr](https://www.mercadomaquinas.com.br/anuncio/214554-pa-carregadeira-caterpillar-950h-2012-curitiba-pr)
    - [https://www.agrofy.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html](https://www.agrofy.com.br/trator-massey-ferguson-4292hd-ano-2015-usado-200035.html)
    - [https://www.tratoresecolheitadeiras.com.br/veiculo/artur-nogueira/sp/retro-escavadeira/randon/rd406/2020/tracao-4x4/cabine-fechada/dovigo-tratores/1167729](https://www.tratoresecolheitadeiras.com.br/veiculo/artur-nogueira/sp/retro-escavadeira/randon/rd406/2020/tracao-4x4/cabine-fechada/dovigo-tratores/1167729)


## Future Development

### Strategy Pattern for Information Output

One potential area for future development is implementing a strategy pattern for the output of collected information. This would allow for flexible handling of how the data is presented. Some options to consider within this pattern include:

- **Data Storage:** Enhance the application to store collected information in a database for easier management and analysis.
- **Report Generation:** Develop functionality to generate reports, such as exporting the collected data to a PDF file. This could provide users with a more structured and visually appealing way to access the information.

These enhancements would provide users with greater flexibility in how they interact with and utilize the data collected by the RPA tool.
