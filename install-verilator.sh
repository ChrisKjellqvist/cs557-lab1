#!/bin/bash

echo "This script is for use only on CS cluster."

git clone https://github.com/verilator/verilator.git
cd verilator || exit
git checkout v4.226-66-gf96454adc
autoconf

INSTALL_DIR="$HOME/.local/verilator"
./configure --prefix="$INSTALL_DIR"

make -j8
make install

echo "################## Pathes for Verilator begin #############"  >> ~/.my-bashrc
echo "export PATH=\$PATH:$INSTALL_DIR/bin"                          >> ~/.my-bashrc
echo "export LD_RUN_PATH=\$LD_RUN_PATH:$INSTALL_DIR/lib"            >> ~/.my-bashrc
echo "export LD_LIBRARY_PATH=\$LD_LIBRARY_PATH:$INSTALL_DIR/lib"    >> ~/.my-bashrc
echo "################## Pathes for Verilator end #############"    >> ~/.my-bashrc

cd .. && rm -rf verilator

echo "--------------------------------------------------------------------------"
echo "-----------------------------  Finished!       ---------------------------"
echo "- Run 'source ~/.bashrc' to  take effect.                                -"
echo "- To uninstall, remove ~/.local/verilator and corresponding lines at the -"
echo "- end of the ~/.my-bashrc                                                -"
echo "--------------------------------------------------------------------------"