getRulesAge() {
    this.http.get(urlConfig.getActiveRulesAgeOrchestrator).subscribe(
        (res: any) => {
            console.log("Dados brutos da API:", res); // Debug ---- realemnte traz os dados da API
            
            this.ageDataSource = res._content.map((item: any) => {
                console.log("Valor de item.modality.modalityCode:", item.modality.modalityCode); // Debug ---- verificar o valor da modalidade
                return {
                    id: item.id,
                    modality: item.modality.modalityCode, // Certifique-se de que modalityCode é a propriedade correta
                    maxAge: item.maximumAge,
                    maxAgeCote: item.remainingDeadline,
                    isEdit: false, // Defina o valor padrão de isEdit aqui
                };
            });

            console.log("ageDataSource após o mapeamento:", this.ageDataSource); // Debug ---- verificar o objeto ageDataSource
        },
        (err) => {
            console.error("Erro ao obter dados da API", err);
        }
    );
