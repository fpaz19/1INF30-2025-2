namespace EjemploSemaforos
{
    partial class frmEjemploSemaforos
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.lbProductor = new System.Windows.Forms.ListBox();
            this.lblProductor = new System.Windows.Forms.Label();
            this.lblConsumidor = new System.Windows.Forms.Label();
            this.lbConsumidor1 = new System.Windows.Forms.ListBox();
            this.label2 = new System.Windows.Forms.Label();
            this.lbConsumidor2 = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // lbProductor
            // 
            this.lbProductor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbProductor.FormattingEnabled = true;
            this.lbProductor.ItemHeight = 20;
            this.lbProductor.Location = new System.Drawing.Point(25, 69);
            this.lbProductor.Name = "lbProductor";
            this.lbProductor.Size = new System.Drawing.Size(231, 284);
            this.lbProductor.TabIndex = 0;
            // 
            // lblProductor
            // 
            this.lblProductor.AutoSize = true;
            this.lblProductor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblProductor.Location = new System.Drawing.Point(21, 27);
            this.lblProductor.Name = "lblProductor";
            this.lblProductor.Size = new System.Drawing.Size(92, 20);
            this.lblProductor.TabIndex = 1;
            this.lblProductor.Text = "Productor:";
            // 
            // lblConsumidor
            // 
            this.lblConsumidor.AutoSize = true;
            this.lblConsumidor.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblConsumidor.Location = new System.Drawing.Point(283, 24);
            this.lblConsumidor.Name = "lblConsumidor";
            this.lblConsumidor.Size = new System.Drawing.Size(124, 20);
            this.lblConsumidor.TabIndex = 3;
            this.lblConsumidor.Text = "Consumidor 1:";
            // 
            // lbConsumidor1
            // 
            this.lbConsumidor1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbConsumidor1.FormattingEnabled = true;
            this.lbConsumidor1.ItemHeight = 20;
            this.lbConsumidor1.Location = new System.Drawing.Point(287, 66);
            this.lbConsumidor1.Name = "lbConsumidor1";
            this.lbConsumidor1.Size = new System.Drawing.Size(231, 284);
            this.lbConsumidor1.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(537, 24);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(124, 20);
            this.label2.TabIndex = 5;
            this.label2.Text = "Consumidor 2:";
            // 
            // lbConsumidor2
            // 
            this.lbConsumidor2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbConsumidor2.FormattingEnabled = true;
            this.lbConsumidor2.ItemHeight = 20;
            this.lbConsumidor2.Location = new System.Drawing.Point(541, 66);
            this.lbConsumidor2.Name = "lbConsumidor2";
            this.lbConsumidor2.Size = new System.Drawing.Size(231, 284);
            this.lbConsumidor2.TabIndex = 4;
            // 
            // frmEjemploSemaforos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 375);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lbConsumidor2);
            this.Controls.Add(this.lblConsumidor);
            this.Controls.Add(this.lbConsumidor1);
            this.Controls.Add(this.lblProductor);
            this.Controls.Add(this.lbProductor);
            this.Name = "frmEjemploSemaforos";
            this.Text = "Formulario Ejemplo Semáforos";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmEjemploSemaforos_FormClosed);
            this.Load += new System.EventHandler(this.frmEjemploSemaforos_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lbProductor;
        private System.Windows.Forms.Label lblProductor;
        private System.Windows.Forms.Label lblConsumidor;
        private System.Windows.Forms.ListBox lbConsumidor1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListBox lbConsumidor2;
    }
}

