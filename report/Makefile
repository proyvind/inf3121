PAPER=report
TEX = TEXINPUTS=./:./latex:$(TEXINPUTS) pdflatex -interaction nonstopmode -halt-on-error

all: $(PAPER).pdf

clean:
	rm -fv $(PAPER).aux $(PAPER).log $(PAPER).dvi $(PAPER).pdf

$(PAPER).pdf: $(PAPER).tex Minesweeper_java-kiviat-metrics-graph-original.png project-kiviat-metrics-graph-original.png project-metrics-summary-original.png latex/ifi-kompendium-forside-eng.png
	$(TEX) $(PAPER) 
